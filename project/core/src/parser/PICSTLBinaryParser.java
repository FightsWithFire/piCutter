package parser;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import abstractgeometry.PICTriangle;
import geometry3D.PICPoint3D;
import tessellation.PICTessellation;

public class PICSTLBinaryParser implements PICParser {
	private PICTessellation<PICPoint3D> tess_;
	byte[] floatBytes_;
	ByteBuffer floatByteBuffer_;

	public PICSTLBinaryParser() {
		// TODO: options.
		tess_ = new PICTessellation<PICPoint3D>();
		floatBytes_ = new byte[4];
		floatByteBuffer_ = ByteBuffer.wrap(floatBytes_);
		floatByteBuffer_.order(ByteOrder.LITTLE_ENDIAN);
	}

	@Override
	public PICTessellation<PICPoint3D> parse(String input) {
		File stlFile = new File(input);
		try (FileInputStream fileStream = new FileInputStream(stlFile);) {
			DataInputStream dataStream = new DataInputStream(fileStream);

			// First off is an 80 byte header that we aren't going to parse.
			byte[] header = new byte[80];
			if (dataStream.read(header) != 80) {
				// TODO: unexpected end of file.
				System.out.println("Read the incorrect number of bytes for the header");
			}

			byte[] firstInt = new byte[4];
			dataStream.read(firstInt);
			ByteBuffer facetCountBuffer = ByteBuffer.wrap(firstInt);
			facetCountBuffer.order(ByteOrder.LITTLE_ENDIAN);
			int facetCount = facetCountBuffer.getInt();

			// Facet count is an unsigned int, which Java doesn't have (although
			// Integer can now do unsigned arithmetic).
			// This won't actually matter unless there is an ungodly number of
			// facets that will cause other issues.
			long faceCountUnsigned = facetCount & 0xffffffffl;
			for (long i = 0; i < faceCountUnsigned; i++) {
				readFace(dataStream);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// Figure out how to convert error to useful user thing.
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return tess_;
	}

	private void readFace(DataInputStream dataStream) throws IOException {
		// A face is a normal and 3 points, the normal is ignored for now.
		readVertex(dataStream);
		PICPoint3D[] points = new PICPoint3D[3];
		for (int i = 0; i < 3; i++) {
			points[i] = readVertex(dataStream);
		}

		tess_.insertTriangle(new PICTriangle<PICPoint3D>(points[0], points[1], points[2]));
		dataStream.readShort();
	}

	private PICPoint3D readVertex(DataInputStream dataStream) throws IOException {
		return new PICPoint3D(readFloat(dataStream), readFloat(dataStream), readFloat(dataStream));
	}

	private float readFloat(DataInputStream dataStream) throws IOException {
		dataStream.read(floatBytes_);
		floatByteBuffer_.position(0);
		return floatByteBuffer_.getFloat();
	}
}
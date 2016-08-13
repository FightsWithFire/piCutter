package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import abstractgeometry.PICTriangle;
import geometry3D.PICPoint3D;
import tessellation.PICTessellation;

public class PICSTLTextParser implements PICParser {
	private PICTessellation<PICPoint3D> tess_;

	public PICSTLTextParser() {
		// TODO: options.
		tess_ = new PICTessellation<PICPoint3D>();
	}

	@Override
	public PICTessellation<PICPoint3D> parse(String input) {
		try (Stream<String> stream = Files.lines(Paths.get(input))) {
			Iterator<String> it = stream.iterator();
			// Currently, all triangles are going into the same tessellation. I
			// may decide to separate by body later.
			// TODO: I may want to make a wrapper that trims each line and
			// stuff.
			while (it.hasNext()) {
				if (it.next().trim().equals("outer loop")) {
					this.processLoop(it);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return tess_;
	}

	void processLoop(Iterator<String> it) {
		// TODO: this probably needs to abort if it crunches into an issue.
		PICPoint3D[] points = new PICPoint3D[3];
		for (int i = 0; i < 3; i++) {
			points[i] = processVertex(it);
		}

		if (!it.next().trim().equals("endloop")) {
			// TODO: throw an exception
		}

		tess_.insertTriangle(new PICTriangle<PICPoint3D>(points[0], points[1], points[2]));
	}

	PICPoint3D processVertex(Iterator<String> it) {
		if (!it.hasNext()) {
			System.out.println("Stream terminates before vertex.");
			return null;
		}

		String line = it.next().trim();
		String[] split = line.split(" ");
		if (split.length != 4) {
			System.out.println("Malformed vertex line.");
			return null;
		}

		if (!split[0].equals("vertex")) {
			System.out.println("Vertex line does not begin with correct keyword");
			return null;
		}
		try {
			return new PICPoint3D(Double.parseDouble(split[1]), Double.parseDouble(split[2]),
					Double.parseDouble(split[3]));

		} catch (NumberFormatException e) {
			System.out.println("Malformed floating point number in stl file.");
		}

		return null;
	}
}

package test;

import org.junit.Assert;
import org.junit.Test;

import geometry3D.PICPoint3D;
import parser.PICSTLBinaryParser;
import tessellation.PICTessellation;

public class PICSTLBinaryParserTest {
	@Test
	public void smokeTest() {
		PICSTLBinaryParser parser = new PICSTLBinaryParser();
		PICTessellation<PICPoint3D> tess = parser.parse("src/test/testdata/cylinder.stl");
		Assert.assertNotNull(tess);
	}
}

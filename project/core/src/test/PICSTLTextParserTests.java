package test;

import org.junit.Assert;
import org.junit.Test;

import parser.PICSTLTextParser;

public class PICSTLTextParserTests {
	@Test
	public void smokeTest() {
		PICSTLTextParser parser = new PICSTLTextParser();
		Assert.assertNotNull(parser.parse("src/test/testdata/two_prisms.stl"));
	}
}

package test;

import org.junit.Test;

import parser.PICSTLTextParser;

public class PICSTLTextParserTests {
	@Test
	public void smokeTest() {
		PICSTLTextParser parser = new PICSTLTextParser();
		parser.parse("src/test/testdata/two_prisms.stl");
	}
}

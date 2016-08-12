package parser;

import java.io.File;

import tessellation.PICTessellation;

public interface PICParser {
	PICTessellation parse(File input);
}

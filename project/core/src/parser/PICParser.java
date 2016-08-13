package parser;

import geometry3D.PICPoint3D;
import tessellation.PICTessellation;

public interface PICParser {
	PICTessellation<PICPoint3D> parse(String input);
}

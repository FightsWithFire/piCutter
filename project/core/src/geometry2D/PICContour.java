package geometry2D;

import java.util.ArrayList;
import java.util.List;

public class PICContour {
	private List<PICPoint2D> points;

	PICContour() {
		points = new ArrayList<PICPoint2D>();
	}

	String dump() {
		StringBuilder sb = new StringBuilder();
		for (PICPoint2D point : points) {
			sb.append(point.dump());
		}
		sb.append(System.lineSeparator());
		return sb.toString();
	}
}

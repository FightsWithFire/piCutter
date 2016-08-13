package geometry2D;

import java.util.List;

public class PICPolygon {
	private List<PICContour> contours;
	
	public String dump() {
		StringBuilder sb = new StringBuilder();
		sb.append("Polygon");
		sb.append(System.lineSeparator());
		for (PICContour contour : contours) {
			sb.append(contour.dump());
		}
		return sb.toString();
	}
}

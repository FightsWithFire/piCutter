package tessellation;

import java.util.ArrayList;
import java.util.List;

import abstractgeometry.PICAbstractPoint;

public class PICPointAtlas<T extends PICAbstractPoint<T>> {
	private List<T> points;
	
	PICPointAtlas() {
		points = new ArrayList<T>();
	}
	
	// This is a naive interpretation.
	int insert(T item) {
		for (int i = 0; i < points.size(); i++) {
			if (item.tolerantEquals(points.get(i))) {
				return i;
			}
		}
		points.add(item);
		return points.size() - 1;
	}
	
	int insertUnique(T item) {
		points.add(item);
		return points.size() - 1;
	}
	
	T get(int index) {
		return points.get(index);
	}
}

package tessellation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TODO: I need to make an abstract point class with a tolerant equals method.
public class PICPointAtlas<T extends PICAbstractPoint<T>> {
	private List<T> points;
	private boolean finished = false;
	
	PICPointAtlas() {
		points = new ArrayList<T>();
	}
	
	boolean insert(T item) {
		if (finished) {
			return false;
		} else {
			points.add(item);
			return true;
		}
	}
	
	boolean finish() {
		if (finished) {
			System.out.println("Trying to finish an atlas more than once.");
			return false;
		}
		Collections.sort(points);
		removeRedundant();
		return true;
	}
	
	private void removeRedundant() {
		// TODO: stub method
	}
	
	int getIndex(T item) {
		return -1;
	}
}

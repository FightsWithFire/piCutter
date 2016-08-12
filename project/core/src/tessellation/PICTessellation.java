package tessellation;

import java.util.LinkedList;

import abstractgeometry.PICAbstractPoint;
import abstractgeometry.PICTriangle;

public class PICTessellation<T extends PICAbstractPoint<T>> {
	PICPointAtlas<T> atlas;
	LinkedList<PICTriangle<T>> tris;
	
	public PICTessellation() {
		atlas = new PICPointAtlas<T>();
		tris = new LinkedList<PICTriangle<T>>();
	}
	
	public void insertTriangle(PICTriangle<T> item) {
		item.p1 = this.reinsert(item.p1);
		item.p2 = this.reinsert(item.p2);
		item.p3 = this.reinsert(item.p3);
		tris.add(item);
	}
	
	private T reinsert(T item) {
		return atlas.get(atlas.insert(item));
	}
	
	public String dump() {
		StringBuilder sb = new StringBuilder();
		for (PICTriangle<T> tri : tris) {
			sb.append(tri.dump());
		}
		return sb.toString();
	}
}

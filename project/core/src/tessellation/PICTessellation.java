package tessellation;

import java.util.LinkedList;

import abstractgeometry.PICAbstractPoint;
import abstractgeometry.PICTriangle;

public class PICTessellation<T extends PICAbstractPoint<T>> {
	PICPointAtlas<T> atlas;
	LinkedList<T> tris;
	
	public PICTessellation() {
		atlas = new PICPointAtlas<T>();
		tris = new LinkedList<T>();
	}
	
	public void insertTriangle(PICTriangle<T> item) {
		// TODO: this is a stub.
	}
}

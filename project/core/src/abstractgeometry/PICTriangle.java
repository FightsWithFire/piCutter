package abstractgeometry;

public class PICTriangle<T extends PICAbstractPoint<T>> {
	T p1, p2, p3;
	
	public PICTriangle(T first, T second, T third) {
		p1 = first;
		p2 = second;
		p3 = third;
	}
}

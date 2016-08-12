package abstractgeometry;

public class PICTriangle<T extends PICAbstractPoint<T>> {
	public T p1, p2, p3;
	
	public PICTriangle(T first, T second, T third) {
		p1 = first;
		p2 = second;
		p3 = third;
	}
	
	public String dump() {
		StringBuilder sb = new StringBuilder();
		sb.append(p1.dump());
		sb.append(p2.dump());
		sb.append(p3.dump());
		return sb.toString();
	}
}

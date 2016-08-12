package abstractgeometry;

public abstract class PICAbstractPoint<T> implements Comparable<T> {
	public abstract boolean tolerantEquals(T other);
}

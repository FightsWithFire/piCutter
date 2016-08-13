package abstractgeometry;

public abstract class PICAbstractPoint<T> {
	public abstract boolean tolerantEquals(T other);
	
	public abstract String dump();
}

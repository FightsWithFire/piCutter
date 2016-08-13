package geometry2D;

import abstractgeometry.PICAbstractPoint;
import constants.PICTolerance;

public class PICPoint2D extends PICAbstractPoint<PICPoint2D> {
	public double x, y;
	
	public PICPoint2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	double distance(PICPoint2D other) {
		return Math.sqrt(distanceSquared(other));
	}
	
	double distanceSquared(PICPoint2D other) {
		return (x - other.x) * (x - other.x) + (y - other.y) * (y - other.y);
	}
	
	double cross(PICPoint2D other) {
		return x * other.y - y * other.x;
	}
	
	double dot(PICPoint2D other) {
		return x * other.x + y * other.y;
	}
	
	PICPoint2D subtract(PICPoint2D other) {
		return new PICPoint2D(x - other.x, y - other.y);
	}
	
	PICPoint2D add(PICPoint2D other) {
		return new PICPoint2D(x + other.x, y + other.y);
	}
	
	PICPoint2D scale(double c) {
		return new PICPoint2D(x * c, y * c);
	}

	@Override
	public boolean tolerantEquals(PICPoint2D other) {
		return distanceSquared(other) < PICTolerance.ZERO_LENGTH * PICTolerance.ZERO_LENGTH;
	}

	@Override
	public String dump() {
		return "x: " + x + ", y: " + y + System.lineSeparator();
	}

}

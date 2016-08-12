package geometry3D;

import abstractgeometry.PICAbstractPoint;
import constants.PICTolerance;

public class PICPoint3D extends PICAbstractPoint<PICPoint3D> {
	double x, y, z;
	
	public PICPoint3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = y;
	}
	
	@Override
	public int compareTo(PICPoint3D other) {
		// TODO: this needs to behave correctly wrt equals and nullpointer exceptions.
		return other.z < z || other.y < y || other.x < x ? -1 : 1;
	}

	double dot(PICPoint3D other) {
		return x * other.x + y * other.y + z * other.z;
	}
	
	double distanceSquared(PICPoint3D other) {
		return (x - other.x ) * (x - other.x) +
				(y - other.y) * (y - other.y) +
				(z - other.z) * (z - other.z);
	}
	
	double distance(PICPoint3D other) {
		return Math.sqrt(distanceSquared(other));
	}
	
	@Override
	public boolean tolerantEquals(PICPoint3D other) {
		return distanceSquared(other) < PICTolerance.ZERO_LENGTH * PICTolerance.ZERO_LENGTH;
	}
	
	public String dump() {
		return "x: " + x + ", y: " + y + ", z: " + z + System.lineSeparator();
	}
}

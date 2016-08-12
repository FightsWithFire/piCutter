package geometry3D;

import constants.PICLengths;
import tessellation.PICAbstractPoint;

public class PICPoint3D extends PICAbstractPoint<PICPoint3D> {
	double x, y, z;
	PICPoint3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = y;
	}
	@Override
	public int compareTo(PICPoint3D other) {
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
		return distanceSquared(other) < PICLengths.ZERO_LENGTH * PICLengths.ZERO_LENGTH;
	}
}

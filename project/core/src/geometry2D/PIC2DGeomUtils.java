package geometry2D;

import constants.PICTolerance;

public class PIC2DGeomUtils {
	// Intersect two line segments <s1, e1> , <s2, e2>
	public static PICPoint2D intersect(PICPoint2D s1, PICPoint2D e1, PICPoint2D s2, PICPoint2D e2) {
		PICPoint2D r = e1.subtract(s1);
		PICPoint2D s = e2.subtract(s2);
		double rcs = r.cross(s);
		double qpr = s2.subtract(s1).cross(r);
		if (Math.abs(rcs) < PICTolerance.ZERO_LENGTH) {
			if (qpr < PICTolerance.ZERO_LENGTH) {
				// overlapping case, will deal with later
				double t0 = s2.subtract(s1).dot(r) / r.dot(r);
				double t1 = t0 + s.dot(r) / r.dot(r);
				if (t0 > t1) {
					double temp = t0;
					t0 = t1;
					t1 = temp;
				}

				if (t0 < 1 + PICTolerance.ZERO_LENGTH && t0 > -PICTolerance.ZERO_LENGTH) {
					t0 = Math.max(0, t0);
					t1 = Math.min(t1, 1);
					// TODO: the proper result in the case is actually a line
					// segment. I'm just returning one of its end points at
					// random.
					return s1.add(r.scale(t0));
				}
				// Line segments are collinear and disjoint.
			} else {
				// non-intersecting case.
				return null;
			}
		} else {
			double u = s2.subtract(s1).cross(r) / rcs;
			double t = s2.subtract(s1).cross(s) / rcs;
			// TODO: I should be using something related to the lengths of the
			// vectors rather than a static tolerance.
			if (-PICTolerance.ZERO_LENGTH < u && u < 1 + PICTolerance.ZERO_LENGTH && -PICTolerance.ZERO_LENGTH < t
					&& t < 1 + PICTolerance.ZERO_LENGTH) {
				// The line segments intersect.
				return s1.add(r.scale(t));
			}
			// The line segments are non-parallel and don't intersect.
		}
		return null;
	}
}

package test;

import org.junit.Test;

import geometry2D.PIC2DGeomUtils;
import geometry2D.PICPoint2D;
import org.junit.Assert;

public class PIC2DGeomUtilsTests {
	@Test
	public void testIntersectingSegments() {
		PICPoint2D start1 = new PICPoint2D(-1, -1);
		PICPoint2D end1 = new PICPoint2D(1, 1);
		PICPoint2D start2 = new PICPoint2D(1, -1);
		PICPoint2D end2 = new PICPoint2D(-1, 1);

		PICPoint2D intersection = PIC2DGeomUtils.intersect(start1, end1, start2, end2);
		PICPoint2D expected = new PICPoint2D(0, 0);
		Assert.assertTrue("Intersection did not match expected point " + expected.dump(),
				expected.tolerantEquals(intersection));
		
		// Same as above with one line with opposite direction
		start1 = new PICPoint2D(1, 1);
		end1 = new PICPoint2D(-1, -1);
		start2 = new PICPoint2D(1, -1);
		end2 = new PICPoint2D(-1, 1);

		intersection = PIC2DGeomUtils.intersect(start1, end1, start2, end2);
		expected = new PICPoint2D(0, 0);
		Assert.assertTrue("Intersection did not match expected point " + expected.dump(),
				expected.tolerantEquals(intersection));
	}

	@Test
	public void testParallelSegments() {
		PICPoint2D start1 = new PICPoint2D(1, 1);
		PICPoint2D end1 = new PICPoint2D(1, 2);
		PICPoint2D start2 = new PICPoint2D(2, 1);
		PICPoint2D end2 = new PICPoint2D(2, 2);

		PICPoint2D intersection = PIC2DGeomUtils.intersect(start1, end1, start2, end2);
		Assert.assertNull(intersection);
	}
	
	@Test
	public void testCoincidentDisjointSegments() {
		PICPoint2D start1 = new PICPoint2D(1, 1);
		PICPoint2D end1 = new PICPoint2D(2, 2);
		PICPoint2D start2 = new PICPoint2D(3, 3);
		PICPoint2D end2 = new PICPoint2D(4, 4);

		PICPoint2D intersection = PIC2DGeomUtils.intersect(start1, end1, start2, end2);
		Assert.assertNull(intersection);
	}
}

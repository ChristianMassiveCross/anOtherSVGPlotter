package svg.element.attribute;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class PathAttributeTest {

	@Test
	public void moveTo() {
		PathAttribute PA = new PathAttribute();
		PA.moveTo(new Point(100,200));
		assertEquals("M 100 200 ", PA.toString());
	}
	@Test
	public void lineTo() {
		PathAttribute PA = new PathAttribute();
		PA.lineTo(new Point(333,666));
		assertEquals("L 333 666 ", PA.toString());
	}
	@Test
	public void CurveTo() {
		PathAttribute PA = new PathAttribute();
		PA.curveTo(
				new Point(1,2),
				new Point(3,4),
				new Point(5,6)
		);
		assertEquals("C 1 2 3 4 5 6 ", PA.toString());
	}
	@Test
	public void smoothCurveTo() {
		PathAttribute PA = new PathAttribute();
		PA.smoothCurveTo(
				new Point(11,22),
				new Point(33,44)
				);
		assertEquals("S 11 22 33 44 ", PA.toString());
	}
	@Test
	public void closePath() {
		PathAttribute PA = new PathAttribute();
		PA.closePath();
		assertEquals("Z ", PA.toString());
	}
	
	@Test
	public void concatPath() {
		PathAttribute PA = new PathAttribute();
		PA.moveTo(new Point(1,2));
		PA.lineTo(new Point (100,200));
		PA.closePath();
		assertEquals("M 1 2 L 100 200 Z ", PA.toString());
	}

}

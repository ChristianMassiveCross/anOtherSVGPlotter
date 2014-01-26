package SVG;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class PathAttributesTest {

	@Test
	public void moveTo() {
		PathAttributes PA = new PathAttributes();
		String result = PA.moveTo(new Point(100,200));
		assertEquals("M 100 200 ", result);
	}
	@Test
	public void lineTo() {
		PathAttributes PA = new PathAttributes();
		String result = PA.lineTo(new Point(333,666));
		assertEquals("L 333 666 ", result);
	}
	@Test
	public void CurveTo() {
		PathAttributes PA = new PathAttributes();
		String result = PA.curveTo(
				new Point(1,2),
				new Point(3,4),
				new Point(5,6)
		);
		assertEquals("C 1 2 3 4 5 6 ", result);
	}
	@Test
	public void smoothCurveTo() {
		PathAttributes PA = new PathAttributes();
		String result = PA.smoothCurveTo(
				new Point(11,22),
				new Point(33,44)
				);
		assertEquals("S 11 22 33 44 ", result);
	}
	@Test
	public void closePath() {
		PathAttributes PA = new PathAttributes();
		String result = PA.closePath();
		assertEquals("Z ", result);
	}

}

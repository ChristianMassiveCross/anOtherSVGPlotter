package SVG;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class CanvasSpliterTest {

	@Test
	public void testGetFields() {
		CanvasSpliter canvasspliter = new CanvasSpliter(100, 100);
		Point [][][] result = canvasspliter.getFields();
		assertArrayEquals(new Point [1][1][2], result);
		fail("Not yet implemented");
	}

}

package SVG;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class CanvasSpliterTest {

	/************************************************************************/
	@Test
	public void testGetFields() {
		this.subTestCanvasIsOneField();
		this.subTestCanvasSplitedInto2Fields();
		this.subTestCanvassplitedInto4Fields();
	}

	/************************************************************************/
	private void subTestCanvasIsOneField() {
		CanvasSpliter canvasspliter = new CanvasSpliter(23, 42);
		Point[][][] result = canvasspliter.getFields();
		Point[][][] expected = new Point[1][1][2];
		expected[0][0][0] = new Point(0, 0);
		expected[0][0][1] = new Point(23, 42);
		
		assertArrayEquals("subTestCanvasIsOneField",expected, result);
	}
	
	/************************************************************************/
	private void subTestCanvasSplitedInto2Fields() {
		CanvasSpliter canvasspliter = new CanvasSpliter(1000, 100);
		canvasspliter.setAmountOfFields(1, 2);
		Point[][][] result = canvasspliter.getFields();
		Point[][][] expected = new Point[1][2][2];
		// top
		expected[0][0][0] = new Point(0, 0);
		expected[0][0][1] = new Point(1000, 50);
		// botton
		expected[0][1][0] = new Point(0, 50);
		expected[0][1][1] = new Point(1000, 100);
		
		assertArrayEquals("subTestCanvassplitedInto2Fields",expected, result);
	}
	
	/************************************************************************/
	private void subTestCanvassplitedInto4Fields() {
		CanvasSpliter canvasspliter = new CanvasSpliter(100, 200);
		canvasspliter.setAmountOfFields(2, 2);
		Point[][][] result = canvasspliter.getFields();
		Point[][][] expected = new Point[2][2][2];
		// top left
		expected[0][0][0] = new Point(0, 0);
		expected[0][0][1] = new Point(50, 100);
		// top right
		expected[0][1][0] = new Point(0, 100);
		expected[0][1][1] = new Point(50, 200);
		// button left
		expected[1][0][0] = new Point(50, 0);
		expected[1][0][1] = new Point(100, 100);
		// button right
		expected[1][1][0] = new Point(50, 100);
		expected[1][1][1] = new Point(100, 200);

		assertArrayEquals("subTestCanvassplitedInto4Fields",expected, result);

	}
}

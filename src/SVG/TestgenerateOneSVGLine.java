package SVG;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.Vector;

import org.junit.Test;
public class TestgenerateOneSVGLine {
	private Point sizeCanvas;

	@Test
	public void test() {
		this.OnePixelResult();
		
	}
	
	private void OnePixelResult () {
		this.setSizeCanvas(new Point(100,50));
		generateLineArray lineCalculation = new generateLineArray(this.getSizeCanvas());
		lineCalculation.setAmountOfDivisions(2);
		Vector<Point> result = lineCalculation.getLine();
		assertArrayEquals("subTestCanvasIsOneField",this.getResultForOnePixel().toArray(), result.toArray());
	}

	private Vector<Point> getResultForOnePixel() {
		int borderLeft = 0;
		int borderRight = this.getSizeCanvas().x;
		int borderTop = 0;
		int borderBottom = this.getSizeCanvas().y;

		Vector<Point> expectedLine = new Vector<Point>();
		// start point
		expectedLine.addElement(new Point(borderLeft,(borderBottom / 2)));
		// middle points
		int secment = borderRight/8;
		expectedLine.addElement(new Point((secment*1),borderTop));
		expectedLine.addElement(new Point((secment*3),borderBottom));
		expectedLine.addElement(new Point((secment*5),borderTop));
		expectedLine.addElement(new Point((secment*7),borderBottom));
		// endPoint 
		expectedLine.addElement(new Point(borderRight,(borderBottom / 2)));
		return expectedLine;
		
	}
	public Point getSizeCanvas() {
		return this.sizeCanvas;
	}
	public void setSizeCanvas(Point sizeCanvas) {
		this.sizeCanvas = sizeCanvas;
	}

}

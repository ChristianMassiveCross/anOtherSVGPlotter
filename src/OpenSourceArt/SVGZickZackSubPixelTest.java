package OpenSourceArt;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class SVGZickZackSubPixelTest {

	@Test
	public void testWithoutZickZack() {
		SVGZickZackSubPixel subPixel = new SVGZickZackSubPixel(0);
		Point startPoint = new Point (100,200);
		Point endPoint = new Point (150,300);
		String SVGPathElement = subPixel.get(startPoint, endPoint);
		System.out.println(SVGPathElement);
		
	}

}

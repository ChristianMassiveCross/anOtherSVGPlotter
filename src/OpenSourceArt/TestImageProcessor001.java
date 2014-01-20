package OpenSourceArt;

import static org.junit.Assert.*;

import java.awt.Point;
import java.io.IOException;
import java.util.Vector;

import image.PNG;

import org.junit.Before;
import org.junit.Test;

public class TestImageProcessor001 {
	PNG png;
	@Before
	public void init() {
		try {
			this.png = new PNG("3to3.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void  test() {
		ImageProcessor imageProcessor = new ImageProcessor001();
		Vector<Point>[] allPoints = imageProcessor.process(this.png);
		
		assertTrue(true);
	}
}

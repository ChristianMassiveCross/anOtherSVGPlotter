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
	public void  TestTheOutputoftheImageProcessor001() {
		ImageProcessor imageProcessor = new ImageProcessor001();
		Vector<String> SVGElements = imageProcessor.process(this.png);
		assertArrayEquals(SVGElements.toArray(), this.getCompareData());
		assertTrue(true);
	}
	private String[] getCompareData (){
		String[] data = new String[9];
		data[0] = "<rect x='0px' y='0px' width='100px' height='100px' style='fill:rgb(255,255,255) stroke:rgb(255,255,255) '  />";
		data[1] = "<rect x='100px' y='0px' width='100px' height='100px' style='fill:rgb(0,0,0) stroke:rgb(0,0,0) '  />";
		data[2] = "<rect x='200px' y='0px' width='100px' height='100px' style='fill:rgb(50,50,50) stroke:rgb(50,50,50) '  />";
		data[3] = "<rect x='0px' y='100px' width='100px' height='100px' style='fill:rgb(100,100,100) stroke:rgb(100,100,100) '  />";
		data[4] = "<rect x='100px' y='100px' width='100px' height='100px' style='fill:rgb(200,200,200) stroke:rgb(200,200,200) '  />";
		data[5] = "<rect x='200px' y='100px' width='100px' height='100px' style='fill:rgb(255,255,255) stroke:rgb(255,255,255) '  />";
		data[6] = "<rect x='0px' y='200px' width='100px' height='100px' style='fill:rgb(255,0,0) stroke:rgb(255,0,0) '  />";
		data[7] = "<rect x='100px' y='200px' width='100px' height='100px' style='fill:rgb(0,255,0) stroke:rgb(0,255,0) '  />";
		data[8] = "<rect x='200px' y='200px' width='100px' height='100px' style='fill:rgb(0,0,255) stroke:rgb(0,0,255) '  />";
		return data;
	}
}

package image.raster.attribute;

import static org.junit.Assert.*;

import org.junit.Test;

public class RGBPixelTest {

	private int helper_createPixelAsBinaryInteger (int red, int green, int blue, int alfa){
		int outputInt = 0;
		outputInt = alfa;
		outputInt <<= 8;
		outputInt += red;
		outputInt <<= 8;
		outputInt += green;
		outputInt <<= 8;
		outputInt += blue;
		return outputInt;
	}
	@Test
	public void testBinaryInput() {
		int AllColorChannels = this.helper_createPixelAsBinaryInteger(10, 20, 30, 255);
		RGBPixel rgbPixel = new RGBPixel(AllColorChannels);
		assertEquals("test red channel", 10, rgbPixel.red());
		assertEquals("test green channel", 20, rgbPixel.green());
		assertEquals("test blue channel", 30, rgbPixel.blue());
		assertEquals("test alfa channel", 255, rgbPixel.alfa());
		assertEquals("test grey channel", 0, rgbPixel.grey());
	}
	@Test
	public void testRGBAlfaInput() {
		RGBPixel rgbPixel = new RGBPixel(10,20,30,40);
		assertEquals("test red channel", 10, rgbPixel.red());
		assertEquals("test green channel", 20, rgbPixel.green());
		assertEquals("test blue channel", 30, rgbPixel.blue());
		assertEquals("test alfa channel", 40, rgbPixel.alfa());
		assertEquals("test grey channel", 0, rgbPixel.grey());
	}
	@Test
	public void testRGBInput() {
		RGBPixel rgbPixel = new RGBPixel(10,20,30);
		assertEquals("test red channel", 10, rgbPixel.red());
		assertEquals("test green channel", 20, rgbPixel.green());
		assertEquals("test blue channel", 30, rgbPixel.blue());
		assertEquals("test alfa channel", 255, rgbPixel.alfa());
		assertEquals("test grey channel", 0, rgbPixel.grey());
	}

}

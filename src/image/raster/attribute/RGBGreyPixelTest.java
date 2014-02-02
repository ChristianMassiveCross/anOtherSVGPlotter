package image.raster.attribute;

import static org.junit.Assert.*;

import org.junit.Test;

public class RGBGreyPixelTest {

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
	public void testFactorRed() {
		int AllColorChannels = this.helper_createPixelAsBinaryInteger(100, 0, 0, 255);
		RGBGreyPixel rgbGreyPixel = new RGBGreyPixel(AllColorChannels);
		rgbGreyPixel.setGreyScaleFactorsPreset("HumanEye");
		assertEquals("test red channel", 100, rgbGreyPixel.red());
		assertEquals("test green channel", 0, rgbGreyPixel.green());
		assertEquals("test blue channel", 0, rgbGreyPixel.blue());
		assertEquals("test alfa channel", 255, rgbGreyPixel.alfa());
		assertEquals("test grey channel", 30, rgbGreyPixel.grey());
	}
	@Test
	public void testFactorGreen() {
		int AllColorChannels = this.helper_createPixelAsBinaryInteger(0, 100, 0, 255);
		RGBGreyPixel rgbGreyPixel = new RGBGreyPixel(AllColorChannels);
		rgbGreyPixel.setGreyScaleFactorsPreset("HumanEye");
		assertEquals("test red channel", 0, rgbGreyPixel.red());
		assertEquals("test green channel", 100, rgbGreyPixel.green());
		assertEquals("test blue channel", 0, rgbGreyPixel.blue());
		assertEquals("test alfa channel", 255, rgbGreyPixel.alfa());
		assertEquals("test grey channel", 59, rgbGreyPixel.grey());
	}
	@Test
	public void testFactorBlue() {
		int AllColorChannels = this.helper_createPixelAsBinaryInteger(0, 0, 100, 255);
		RGBGreyPixel rgbGreyPixel = new RGBGreyPixel(AllColorChannels);
		rgbGreyPixel.setGreyScaleFactorsPreset("HumanEye");
		assertEquals("test red channel", 0, rgbGreyPixel.red());
		assertEquals("test green channel", 0, rgbGreyPixel.green());
		assertEquals("test blue channel", 100, rgbGreyPixel.blue());
		assertEquals("test alfa channel", 255, rgbGreyPixel.alfa());
		assertEquals("test grey channel", 11, rgbGreyPixel.grey());
	}

}

package image;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class FirstTest {
	PNG png = null;

	@Before
	public void init() {
		try {
			this.png = new PNG("3to3.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TestAverageGreyValuesWithgetNextLineIterator() {
		int[][] compareValues = this.getExpectedAverageGreyValues();
		for (int y = 0; y < png.getHeight(); y++) {
			int x = 0;
			for (Iterator<RGBGreyPixel> iterator = png.getNextLine().iterator(); iterator.hasNext();) {
				int aGreyValue = iterator.next().grey();
				assertEquals("proof the average grey value calculation", compareValues[x][y], aGreyValue);
				x++;
			}
		}
	}

	@Test
	public void TestImageFormat() {
		int imageHeigth = this.png.getHeight();
		assertEquals("get correct Heigth", imageHeigth, 3);
		int imageWidth = this.png.getWidth();
		assertEquals("get correct Width", imageWidth, 3);
	}

	@Test
	public void TestHumanEyeGreyValues() {
		PNG png = this.png;
		png.setGreyScaleFactorsPreset("HumanEye");
		int[][] compareValues = this.getExpectedHumanEyeGreyValues();
		for (int y = 0; y < png.getHeight(); y++) {
			for (int x = 0; x < png.getWidth(); x++) {
				assertEquals("proof the 'HumanEye' grey value calculation",
						compareValues[x][y], png.getPixelInGrey(x, y));
			}
		}
	}

	@Test
	public void TestZeroRedGreyValues() {
		PNG png = this.png;
		png.setGreyScaleFactorsPreset("ZeroRed");
		int[][] compareValues = this.getExpectedZeroRedGreyValues();
		for (int y = 0; y < png.getHeight(); y++) {
			for (int x = 0; x < png.getWidth(); x++) {
				assertEquals("proof the 'ZeroRed' grey value calculation",
						compareValues[x][y], png.getPixelInGrey(x, y));
			}
		}
	}

	@Test
	public void TestLuminosityGreyValues() {
		PNG png = this.png;
		png.setGreyScaleFactorsPreset("Luminosity");
		int[][] compareValues = this.getExpectedLuminosityGreyValues();
		for (int y = 0; y < png.getHeight(); y++) {
			for (int x = 0; x < png.getWidth(); x++) {
				assertEquals("proof the 'Luminosity' grey value calculation",
						compareValues[x][y], png.getPixelInGrey(x, y));
			}
		}
	}

	@Test
	public void TestColorValues() {
		PNG png = this.png;
		String[][] compareValues = this.getExpectedColorValues();
		for (int y = 0; y < png.getHeight(); y++) {
			for (int x = 0; x < png.getWidth(); x++) {
				String RGBValues = "R:";
				RGBValues += png.getPixelInRed(x, y);
				RGBValues += ",G:";
				RGBValues += png.getPixelInGreen(x, y);
				RGBValues += ",B:";
				RGBValues += png.getPixelInBlue(x, y);
				RGBValues += ",Alfa:";
				RGBValues += png.getPixelInAlfa(x, y);
				assertEquals("Pixels hace correct Pos and Color",
						compareValues[x][y], RGBValues);
			}
		}
	}

	private String[][] getExpectedColorValues() {
		String[][] PictureAsString = new String[3][3];
		PictureAsString[0][0] = "R:255,G:255,B:255,Alfa:255";
		PictureAsString[1][0] = "R:0,G:0,B:0,Alfa:255";
		PictureAsString[2][0] = "R:50,G:50,B:50,Alfa:255";
		PictureAsString[0][1] = "R:100,G:100,B:100,Alfa:255";
		PictureAsString[1][1] = "R:200,G:200,B:200,Alfa:255";
		PictureAsString[2][1] = "R:255,G:255,B:255,Alfa:255";
		PictureAsString[0][2] = "R:255,G:0,B:0,Alfa:255";
		PictureAsString[1][2] = "R:0,G:255,B:0,Alfa:255";
		PictureAsString[2][2] = "R:0,G:0,B:255,Alfa:255";
		return PictureAsString;
	}

	private int[][] getExpectedAverageGreyValues() {
		int[][] PictureAsString = new int[3][3];
		PictureAsString[0][0] = 255;
		PictureAsString[1][0] = 0;
		PictureAsString[2][0] = 50;
		PictureAsString[0][1] = 100;
		PictureAsString[1][1] = 200;
		PictureAsString[2][1] = 255;
		PictureAsString[0][2] = 85;
		PictureAsString[1][2] = 85;
		PictureAsString[2][2] = 85;
		return PictureAsString;
	}

	private int[][] getExpectedHumanEyeGreyValues() {
		int[][] PictureAsString = new int[3][3];
		PictureAsString[0][0] = 255;
		PictureAsString[1][0] = 0;
		PictureAsString[2][0] = 50;
		PictureAsString[0][1] = 100;
		PictureAsString[1][1] = 200;
		PictureAsString[2][1] = 255;
		PictureAsString[0][2] = 76;
		PictureAsString[1][2] = 150;
		PictureAsString[2][2] = 29;
		return PictureAsString;
	}

	private int[][] getExpectedZeroRedGreyValues() {
		int[][] PictureAsString = new int[3][3];
		PictureAsString[0][0] = 255;
		PictureAsString[1][0] = 0;
		PictureAsString[2][0] = 50;
		PictureAsString[0][1] = 100;
		PictureAsString[1][1] = 200;
		PictureAsString[2][1] = 255;
		PictureAsString[0][2] = 0;
		PictureAsString[1][2] = 188;
		PictureAsString[2][2] = 67;
		return PictureAsString;
	}

	private int[][] getExpectedLuminosityGreyValues() {
		int[][] PictureAsString = new int[3][3];
		PictureAsString[0][0] = 255;
		PictureAsString[1][0] = 0;
		PictureAsString[2][0] = 50;
		PictureAsString[0][1] = 100;
		PictureAsString[1][1] = 200;
		PictureAsString[2][1] = 255;
		PictureAsString[0][2] = 54;
		PictureAsString[1][2] = 180;
		PictureAsString[2][2] = 21;
		return PictureAsString;
	}
}

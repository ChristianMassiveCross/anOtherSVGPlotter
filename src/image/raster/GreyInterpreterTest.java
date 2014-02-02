package image.raster;

import static org.junit.Assert.*;
import image.raster.attribute.Pixel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class GreyInterpreterTest {

	private Pixel[][] helper_getPixelMatrix(String schemaName)
			throws IOException {
		String pathToTestPicture = "./src/image/raster/PictureForTest.png";
		File FileHandler = new File(pathToTestPicture);
		BufferedImage bufferedImage = ImageIO.read(FileHandler);
		GreyInterpreter greyInterpreter = new GreyInterpreter();
		greyInterpreter.setSchemaName(schemaName);
		greyInterpreter.readImage(bufferedImage);
		Pixel[][] pixelMatrix = greyInterpreter.getPixelMatrix();
		return pixelMatrix;
	}

	@Test
	public void testRGBInterpreterWithAverageSchema() throws IOException {
		String schemaName = "Average";
		Pixel[][] pixelMatrix = this.helper_getPixelMatrix(schemaName);
		assertEquals("test right lenght of X default lenght", 3,
				pixelMatrix.length);
		assertEquals("test right lenght of X default lenght", 3,
				pixelMatrix[0].length);
		this.testGreyValues(schemaName, pixelMatrix,
				this.getExpectedAverageGreyValues());
	}

	@Test
	public void testRGBInterpreterWithHumanEyeSchema() throws IOException {
		String schemaName = "HumanEye";
		Pixel[][] pixelMatrix = this.helper_getPixelMatrix(schemaName);
		assertEquals("test right lenght of X default lenght", 3,
				pixelMatrix.length);
		assertEquals("test right lenght of X default lenght", 3,
				pixelMatrix[0].length);
		this.testGreyValues(schemaName, pixelMatrix,
				this.getExpectedHumanEyeGreyValues());
	}
	@Test
	public void testRGBInterpreterWithZeroRedSchema() throws IOException {
		String schemaName = "ZeroRed";
		Pixel[][] pixelMatrix = this.helper_getPixelMatrix(schemaName);
		assertEquals("test right lenght of X default lenght", 3,
				pixelMatrix.length);
		assertEquals("test right lenght of X default lenght", 3,
				pixelMatrix[0].length);
		this.testGreyValues(schemaName, pixelMatrix,
				this.getExpectedZeroRedGreyValues());
	}
	@Test
	public void testRGBInterpreterWithLuminositySchema() throws IOException {
		String schemaName = "Luminosity";
		Pixel[][] pixelMatrix = this.helper_getPixelMatrix(schemaName);
		assertEquals("test right lenght of X default lenght", 3,
				pixelMatrix.length);
		assertEquals("test right lenght of X default lenght", 3,
				pixelMatrix[0].length);
		this.testGreyValues(schemaName, pixelMatrix,
				this.getExpectedLuminosityGreyValues());
	}

	private void testGreyValues(String schemaName, Pixel[][] pixelMatrix,
			int[][] expectedMatrix) {
		for (int y = 0; y < pixelMatrix.length; y++) {
			for (int x = 0; x < pixelMatrix[y].length; x++) {
				assertEquals("check " + schemaName + " pos x:" + x + " y:" + y,
						expectedMatrix[x][y], pixelMatrix[x][y].grey());
			}
		}
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

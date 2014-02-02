package image.raster;

import static org.junit.Assert.*;
import image.raster.attribute.Pixel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class RGBInterpreterTest {
	private BufferedImage helper_getBufferedImage () throws IOException{
		String pathToTestPicture = "./src/image/raster/PictureForTest.png";
		File FileHandler = new File(pathToTestPicture);
		return ImageIO.read(FileHandler);
	}
	@Test
	public void testRGBInterpreter() throws IOException{
		BufferedImage bufferedImage = this.helper_getBufferedImage();
		BaseInterpreter baseInterpreter = new RGBInterpreter();
		baseInterpreter.readImage(bufferedImage);
		Pixel[][] pixelMatrix = baseInterpreter.getPixelMatrix();
		assertEquals("test right lenght of X default lenght",3, pixelMatrix.length);
		assertEquals("test right lenght of X default lenght",3, pixelMatrix[0].length);
		this.TestColorValues(pixelMatrix);
	}
	private void TestColorValues(Pixel[][] pixelMatrix) {
		String[][] compareValues = this.getExpectedColorValues();
		for (int y = 0; y < pixelMatrix.length; y++) {
			for (int x = 0; x < pixelMatrix[y].length; x++) {
				String RGBValues = "R:";
				RGBValues += pixelMatrix[x][y].red(); 
				RGBValues += ",G:";
				RGBValues += pixelMatrix[x][y].green();
				RGBValues += ",B:";
				RGBValues += pixelMatrix[x][y].blue();
				RGBValues += ",Alfa:";
				RGBValues += pixelMatrix[x][y].alfa();
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


}

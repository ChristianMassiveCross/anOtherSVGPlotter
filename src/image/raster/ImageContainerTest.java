package image.raster;

import static org.junit.Assert.*;

import image.raster.attribute.Pixel;

import java.io.IOException;

import org.junit.Test;

public class ImageContainerTest {

	@Test
	public void callWithTestPictureAndBinaryInterpreter() throws IOException {
		String pathToTestPicture = "./src/image/raster/PictureForTest.png";
		BinaryInterpreter binaryInterpreter = new BaseInterpreter();
		ImageContainer imageContainer = new ImageContainer(pathToTestPicture,binaryInterpreter);
		assertEquals("check for height",3, imageContainer.getHeight());
		assertEquals("check for width",3, imageContainer.getWidth());
		Pixel[][] pixelMatrix = imageContainer.getPixelMatrix();
		assertEquals("lenght y axis",3, pixelMatrix.length);
		assertEquals("lenght x axis",3, pixelMatrix[0].length);
	}
	@Test
	public void callWithTestPicture() throws IOException {
		String pathToTestPicture = "./src/image/raster/PictureForTest.png";
		ImageContainer imageContainer = new ImageContainer(pathToTestPicture);
		assertEquals("check for height",3, imageContainer.getHeight());
		assertEquals("check for width",3, imageContainer.getWidth());
		Pixel[][] pixelMatrix = imageContainer.getPixelMatrix();
		assertEquals("lenght y axis",3, pixelMatrix.length);
		assertEquals("lenght x axis",3, pixelMatrix[0].length);
	}

}

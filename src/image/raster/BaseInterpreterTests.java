package image.raster;

import static org.junit.Assert.*;

import image.raster.attribute.Pixel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class BaseInterpreterTests {
	private BufferedImage helper_getBufferedImage () throws IOException{
		String pathToTestPicture = "./src/image/raster/PictureForTest.png";
		File FileHandler = new File(pathToTestPicture);
		return ImageIO.read(FileHandler);
	}
	@Test
	public void testBaseInterpreter() throws IOException{
		BufferedImage bufferedImage = this.helper_getBufferedImage();
		BaseInterpreter baseInterpreter = new BaseInterpreter();
		baseInterpreter.readImage(bufferedImage);
		Pixel[][] pixelMatrix = baseInterpreter.getPixelMatrix();
		assertEquals("test right lenght of X default lenght",3, pixelMatrix.length);
		assertEquals("test right lenght of X default lenght",3, pixelMatrix[0].length);
	}
	
}

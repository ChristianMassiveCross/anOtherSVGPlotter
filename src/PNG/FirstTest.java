package PNG;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.junit.Test;
import javax.imageio.ImageIO;

public class FirstTest {

	@Test
	public void test() {
		BufferedImage a = null;
		try {
			File file = new File( "3to3.png" );
			assertTrue(file.canRead());
			a = ImageIO.read( file );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("could load Image", a.getRGB(0, 0),12);
		int imageHeigth = a.getHeight();
		assertEquals("get correct Heigth", imageHeigth, 3);
		int imageWidth = a. getWidth();
		assertEquals("get correct Width", imageWidth, 3);
	}

}

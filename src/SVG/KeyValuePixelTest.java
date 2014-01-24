package SVG;

import static org.junit.Assert.*;

import org.junit.Test;

public class KeyValuePixelTest {

	@Test
	public void test() {
		KeyValuePixel kvp = new KeyValuePixel("pixelKey", "pixelValue");
		assertEquals(kvp.toString(), "pixelKey='pixelValuepx' ");
	}

}

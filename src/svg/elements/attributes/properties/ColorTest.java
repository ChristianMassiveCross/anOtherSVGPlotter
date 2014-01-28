package svg.elements.attributes.properties;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorTest {

	@Test
	public void defaultConstruktor() {
		Color color = new Color();
		String result = color.toString();
		assertEquals("none", result);
	}
	@Test
	public void greyConstruktor() {
		Color color = new Color(123);
		String result = color.toString();
		assertEquals("rgb(123,123,123)", result);
	}
	@Test
	public void rgbConstruktor() {
		Color color = new Color(11,22,33);
		String result = color.toString();
		assertEquals("rgb(11,22,33)", result);
	}

}

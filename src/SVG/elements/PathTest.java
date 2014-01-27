package SVG.elements;

import static org.junit.Assert.*;

import org.junit.Test;

public class PathTest {

	@Test
	public void pathWithoutAnySettings() {
		Path path = new Path();
		String result = path.getAsString();
		assertEquals("<path d='' style=''/>", result);
	}
	public void pathWithSettings() {
		Path path = new Path();
		path.setCoordinates("coordinates");
		path.setStyle("style");
		String result = path.getAsString();
		assertEquals("<path d='coordinates' style='style'/>", result);
	}
}

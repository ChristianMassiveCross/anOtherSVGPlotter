package SVG.elements;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import svg.elements.attributes.PathAttributes;

public class PathTest {

	@Test
	public void pathWithoutAnySettings() {
		Path path = new Path();
		String result = path.getAsString();
		assertEquals("<path d='' style=''/>", result);
	}

	@Test
	public void pathWithRealData() {
		Path path = new Path();
		PathAttributes pathAttributes = new PathAttributes();
		pathAttributes.moveTo(new Point(12,10));
		pathAttributes.lineTo(new Point(100,200));
		path.setPathAtributes(pathAttributes);
		path.setStyle("style");
		String result = path.getAsString();
		assertEquals("<path d='M 12 10 L 100 200 ' style='style'/>", result);
	}
}

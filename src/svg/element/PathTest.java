package svg.element;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import svg.element.attribute.PathAttributes;
import svg.element.attribute.StyleAttributes;
import svg.element.attribute.property.Color;

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
		
		StyleAttributes styleAttributes = new StyleAttributes();
		styleAttributes.fill(new Color(123));
		styleAttributes.stroke(new Color());
		path.setStyle(styleAttributes);
		String result = path.getAsString();
		assertEquals("<path d='M 12 10 L 100 200 ' style='fill:rgb(123,123,123); stroke:none; '/>", result);
	}
}
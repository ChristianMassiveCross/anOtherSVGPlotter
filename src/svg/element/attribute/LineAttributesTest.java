package svg.element.attribute;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class LineAttributesTest {

	@Test
	public void normalLineAttribute() {
		LineAttributes lineAttribute = new LineAttributes();
		lineAttribute.setStartAndEndPoint(new Point(1,2), new Point(3,4));
		assertEquals(
				"x1='1' y1='2' x2='3' y2='4' ",
				lineAttribute.toString()
		);
	}

}

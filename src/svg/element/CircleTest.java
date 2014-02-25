package svg.element;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import svg.element.attribute.CirclePositionAttribute;

public class CircleTest {

	@Test
	public void getCircleAsString() {
		CirclePositionAttribute Position = new CirclePositionAttribute();
		Position.setPosition(new Point(33,44));
		int Radius = 22;
		Circle circle = new Circle(Position, Radius);
		assertEquals("Test if the complete String is printed", 
				"<circle cx='33px' cy='44px' r='22' style='' />", 
				circle.getAsString()
		);
	}

}

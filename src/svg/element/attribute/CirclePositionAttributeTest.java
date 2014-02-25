package svg.element.attribute;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import svg.element.attribute.property.Unit;

public class CirclePositionAttributeTest {

	@Test
	public void TestWithSpecialUnit() {
		CirclePositionAttribute circlepositionAttributes = new CirclePositionAttribute();
		Point position = new Point(1,2);
		Unit unit = new Unit("ptx");
		circlepositionAttributes.setPosition(position, unit);
		assertEquals("cx='1ptx' cy='2ptx'", circlepositionAttributes.toString());
	}

	@Test
	public void TestWithStandardUnit() {
		CirclePositionAttribute circlepositionAttributes = new CirclePositionAttribute();
		Point position = new Point(1,2);
		Unit unit = new Unit();
		circlepositionAttributes.setPosition(position, unit);
		assertEquals("cx='1px' cy='2px'", circlepositionAttributes.toString());
	}
}

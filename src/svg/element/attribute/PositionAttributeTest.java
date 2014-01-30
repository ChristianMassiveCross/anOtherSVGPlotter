package svg.element.attribute;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import svg.element.attribute.property.Unit;

public class PositionAttributeTest {

	@Test
	public void TestWithSpecialUnit() {
		PositionAttribute positionAttributes = new PositionAttribute();
		Point position = new Point(1,2);
		Unit unit = new Unit("ptx");
		positionAttributes.setPosition(position, unit);
		assertEquals("x='1ptx' y='2ptx'", positionAttributes.toString());
	}

	@Test
	public void TestWithStandardUnit() {
		PositionAttribute positionAttributes = new PositionAttribute();
		Point position = new Point(1,2);
		Unit unit = new Unit();
		positionAttributes.setPosition(position, unit);
		assertEquals("x='1px' y='2px'", positionAttributes.toString());
	}
}

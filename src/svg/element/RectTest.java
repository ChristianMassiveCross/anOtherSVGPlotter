package svg.element;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import svg.element.attribute.AreaAttribute;
import svg.element.attribute.PositionAttribute;
import svg.element.attribute.StyleAttribute;
import svg.element.attribute.property.Color;

public class RectTest {

	@Test
	public void normalCall() {
		PositionAttribute position = new PositionAttribute();
		position.setPosition(new Point(23,24));
		AreaAttribute area = new AreaAttribute();
		area.setArea(100,200);
		StyleAttribute style = new StyleAttribute();
		style.fill(new Color(6));
		Rect rect = new Rect(position, area, style);
		assertEquals("<rect x='23px' y='24px' width='100px' height='200px' style='fill:rgb(6,6,6); '/>", rect.getAsString());
	}

}

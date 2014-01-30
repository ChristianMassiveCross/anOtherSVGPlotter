package svg.element;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import svg.element.attribute.LineAttribute;
import svg.element.attribute.StyleAttribute;
import svg.element.attribute.property.Color;

public class LineTest {

	@Test
	public void normalLine() {
		Line line = new Line();
		
		LineAttribute lineAttributes = new LineAttribute();
		lineAttributes.setStartAndEndPoint(new Point (1,2), new Point(3,4));
		line.setPosition(lineAttributes);
		
		StyleAttribute styleAttributes = new StyleAttribute();
		styleAttributes.strokeWidth(1.2f);
		styleAttributes.stroke(new Color(4,55,255));
		line.setStyle(styleAttributes);
		
		assertEquals("<line x1='1' y1='2' x2='3' y2='4'  " +
					 "style='stroke-width:1.2px; stroke:rgb(4,55,255); '/>",
					 line.getAsString()
		);
	}
	@Test
	public void LineWithoutParameters() {
		Line line = new Line();
		line.getAsString();
		assertEquals("<line  style=''/>", line.getAsString() );
	}

}

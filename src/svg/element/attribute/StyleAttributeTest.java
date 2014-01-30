package svg.element.attribute;

import static org.junit.Assert.*;

import org.junit.Test;

import svg.element.attribute.property.Color;
import svg.element.attribute.property.Unit;

public class StyleAttributeTest {

	@Test
	public void fill() {
		StyleAttribute styleAttributes = new StyleAttribute();
		Color color = new Color();
		styleAttributes.fill(color);
		assertEquals("fill:none; ", styleAttributes.toString());
	}

	@Test
	public void stroke() {
		StyleAttribute styleAttributes = new StyleAttribute();
		Color color = new Color(33);
		styleAttributes.stroke(color);
		assertEquals("stroke:rgb(33,33,33); ", styleAttributes.toString());
	}

	@Test
	public void strokeWidth() {
		StyleAttribute styleAttributes = new StyleAttribute();
		styleAttributes.strokeWidth(0.5f);
		assertEquals("stroke-width:0.5px; ", styleAttributes.toString());
	}

	@Test
	public void strokeWidthAndChangedUnit() {
		StyleAttribute styleAttributes = new StyleAttribute();
		Unit unit = new Unit("xXx");
		styleAttributes.strokeWidth(3.7f, unit);
		assertEquals("stroke-width:3.7xXx; ", styleAttributes.toString());
	}

	@Test
	public void strokeOpacity() {
		StyleAttribute styleAttributes = new StyleAttribute();
		styleAttributes.strokeOpacity(65);
		assertEquals("stroke-opacity:0.65; ", styleAttributes.toString());
	}
	
	@Test
	public void fillOpacity() {
		StyleAttribute styleAttributes = new StyleAttribute();
		styleAttributes.fillOpacity(33);
		assertEquals("fill-opacity:0.33; ", styleAttributes.toString());
	}

}

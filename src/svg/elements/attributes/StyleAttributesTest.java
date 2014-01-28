package svg.elements.attributes;

import static org.junit.Assert.*;

import org.junit.Test;

import svg.elements.attributes.properties.Color;
import svg.elements.attributes.properties.Unit;

public class StyleAttributesTest {

	@Test
	public void fill() {
		StyleAttributes styleAttributes = new StyleAttributes();
		Color color = new Color();
		styleAttributes.fill(color);
		assertEquals("fill:none; ", styleAttributes.toString());
	}

	@Test
	public void stroke() {
		StyleAttributes styleAttributes = new StyleAttributes();
		Color color = new Color(33);
		styleAttributes.stroke(color);
		assertEquals("stroke:rgb(33,33,33); ", styleAttributes.toString());
	}

	@Test
	public void strokeWidth() {
		StyleAttributes styleAttributes = new StyleAttributes();
		styleAttributes.strokeWidth(0.5f);
		assertEquals("stroke-width:0.5px; ", styleAttributes.toString());
	}

	@Test
	public void strokeWidthAndChangedUnit() {
		StyleAttributes styleAttributes = new StyleAttributes();
		Unit unit = new Unit();
		unit.setUnitAbbreviation("xXx");
		styleAttributes.strokeWidth(3.7f, unit);
		assertEquals("stroke-width:3.7xXx; ", styleAttributes.toString());
	}

	@Test
	public void strokeOpacity() {
		StyleAttributes styleAttributes = new StyleAttributes();
		styleAttributes.strokeOpacity(65);
		assertEquals("stroke-opacity:0.65; ", styleAttributes.toString());
	}
	
	@Test
	public void fillOpacity() {
		StyleAttributes styleAttributes = new StyleAttributes();
		styleAttributes.fillOpacity(33);
		assertEquals("fill-opacity:0.33; ", styleAttributes.toString());
	}

}

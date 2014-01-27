package svg.elements.attributes;

import static org.junit.Assert.*;

import org.junit.Test;

public class StyleAttributesTest {

	@Test
	public void fill() {
		StyleAttributes styleAttributes = new StyleAttributes();
		Color color = new Color();
		String result = styleAttributes.fill(color);
		assertEquals("fill:none; ", result);
	}

	@Test
	public void stroke() {
		StyleAttributes styleAttributes = new StyleAttributes();
		Color color = new Color(33);
		String result = styleAttributes.stroke(color);
		assertEquals("stroke:rgb(33,33,33); ", result);
	}

	@Test
	public void strokeWidth() {
		StyleAttributes styleAttributes = new StyleAttributes();
		String result = styleAttributes.strokeWidth(0.5f);
		assertEquals("stroke-width:0.5px; ", result);
	}

	@Test
	public void strokeWidthAndChangedUnit() {
		StyleAttributes styleAttributes = new StyleAttributes();
		Unit unit = new Unit();
		unit.setUnitAbbreviation("xXx");
		String result = styleAttributes.strokeWidth(3.7f, unit);
		assertEquals("stroke-width:3.7xXx; ", result);
	}

	@Test
	public void strokeOpacity() {
		StyleAttributes styleAttributes = new StyleAttributes();
		String result = styleAttributes.strokeOpacity(65);
		assertEquals("stroke-opacity:0.65; ", result);
	}
	
	@Test
	public void fillOpacity() {
		StyleAttributes styleAttributes = new StyleAttributes();
		String result = styleAttributes.fillOpacity(33);
		assertEquals("fill-opacity:0.33; ", result);
	}
	
	@Test
	public void strokeLinecap_Butt() {
		StyleAttributes styleAttributes = new StyleAttributes();
		String result = styleAttributes.strokeLinecap();
		assertEquals("stroke-linecap:butt; ", result);
		result = styleAttributes.strokeLinecap("SomthingWrong");
		assertEquals("stroke-linecap:butt; ", result);
		result = styleAttributes.strokeLinecap("short");
		assertEquals("stroke-linecap:butt; ", result);
		result = styleAttributes.strokeLinecap("butt");
		assertEquals("stroke-linecap:butt; ", result);
	}
	
	@Test
	public void strokeLinecap_Round() {
		StyleAttributes styleAttributes = new StyleAttributes();
		String result = styleAttributes.strokeLinecap("round");
		assertEquals("stroke-linecap:round; ", result);
		result = styleAttributes.strokeLinecap("middle");
		assertEquals("stroke-linecap:round; ", result);
	}
	
	@Test
	public void strokeLinecap_Square() {
		StyleAttributes styleAttributes = new StyleAttributes();
		String result = styleAttributes.strokeLinecap("square");
		assertEquals("stroke-linecap:square; ", result);
		result = styleAttributes.strokeLinecap("long");
		assertEquals("stroke-linecap:square; ", result);
	}
	
	@Test
	public void strokeLineJoin_miter() {
		StyleAttributes styleAttributes = new StyleAttributes();
		String result = styleAttributes.strokeLinejoin();
		assertEquals("noValue","stroke-linejoin:miter; ", result);
		result = styleAttributes.strokeLinejoin("SomthingWrong");
		assertEquals("Value: SomthingWrong","stroke-linejoin:miter; ", result);
		result = styleAttributes.strokeLinejoin("miter");
		assertEquals("Value: miter","stroke-linejoin:miter; ", result);
		result = styleAttributes.strokeLinejoin("spiky");
		assertEquals("Value: spiky","stroke-linejoin:miter; ", result);
	}
	
	@Test
	public void strokeLineJoin_bevel() {
		StyleAttributes styleAttributes = new StyleAttributes();
		String result = styleAttributes.strokeLinejoin("bevel");
		assertEquals("stroke-linejoin:bevel; ", result);
		result = styleAttributes.strokeLinejoin("flat");
		assertEquals("stroke-linejoin:bevel; ", result);
	}
	
	@Test
	public void strokeLineJoin_round() {
		StyleAttributes styleAttributes = new StyleAttributes();
		String result = styleAttributes.strokeLinejoin("round");
		assertEquals("stroke-linejoin:round; ", result);
	}
}

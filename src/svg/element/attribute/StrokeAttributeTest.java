package svg.element.attribute;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrokeAttributeTest {

	@Test
	public void strokeLinecap_default() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinecap();
		assertEquals("stroke-linecap:butt; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_undefined() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinecap("SomthingWrong");
		assertEquals("stroke-linecap:butt; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_short() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinecap("short");
		assertEquals("stroke-linecap:butt; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_butt() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinecap("butt");
		assertEquals("stroke-linecap:butt; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_Round() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinecap("round");
		assertEquals("stroke-linecap:round; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_middle() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinecap("middle");
		assertEquals("stroke-linecap:round; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_Square() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinecap("square");
		assertEquals("stroke-linecap:square; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_Long() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinecap("long");
		assertEquals("stroke-linecap:square; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_default() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinejoin();
		assertEquals("stroke-linejoin:miter; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_undefind() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinejoin("SomthingWrong");
		assertEquals("stroke-linejoin:miter; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_miter() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinejoin("miter");
		assertEquals("stroke-linejoin:miter; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_spiky() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinejoin("spiky");
		assertEquals("stroke-linejoin:miter; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_bevel() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinejoin("bevel");
		assertEquals("stroke-linejoin:bevel; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_flat() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinejoin("flat");
		assertEquals("stroke-linejoin:bevel; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_round() {
		StrokeAttribute strokeAttributes = new StrokeAttribute();
		strokeAttributes.strokeLinejoin("round");
		assertEquals("stroke-linejoin:round; ", strokeAttributes.toString());
	}

}

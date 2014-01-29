package svg.element.attribute;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrokeAttributesTest {

	@Test
	public void strokeLinecap_default() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinecap();
		assertEquals("stroke-linecap:butt; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_undefined() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinecap("SomthingWrong");
		assertEquals("stroke-linecap:butt; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_short() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinecap("short");
		assertEquals("stroke-linecap:butt; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_butt() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinecap("butt");
		assertEquals("stroke-linecap:butt; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_Round() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinecap("round");
		assertEquals("stroke-linecap:round; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_middle() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinecap("middle");
		assertEquals("stroke-linecap:round; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_Square() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinecap("square");
		assertEquals("stroke-linecap:square; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLinecap_Long() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinecap("long");
		assertEquals("stroke-linecap:square; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_default() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinejoin();
		assertEquals("stroke-linejoin:miter; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_undefind() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinejoin("SomthingWrong");
		assertEquals("stroke-linejoin:miter; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_miter() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinejoin("miter");
		assertEquals("stroke-linejoin:miter; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_spiky() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinejoin("spiky");
		assertEquals("stroke-linejoin:miter; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_bevel() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinejoin("bevel");
		assertEquals("stroke-linejoin:bevel; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_flat() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinejoin("flat");
		assertEquals("stroke-linejoin:bevel; ", strokeAttributes.toString());
	}

	@Test
	public void strokeLineJoin_round() {
		StrokeAttributes strokeAttributes = new StrokeAttributes();
		strokeAttributes.strokeLinejoin("round");
		assertEquals("stroke-linejoin:round; ", strokeAttributes.toString());
	}

}

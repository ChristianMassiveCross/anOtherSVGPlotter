package svg.elements.attributes;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineAttributesTest {

	@Test
	public void strokeLinecap_default() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinecap();
		assertEquals("stroke-linecap:butt; ", lineAttributes.toString());
	}

	@Test
	public void strokeLinecap_undefined() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinecap("SomthingWrong");
		assertEquals("stroke-linecap:butt; ", lineAttributes.toString());
	}

	@Test
	public void strokeLinecap_short() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinecap("short");
		assertEquals("stroke-linecap:butt; ", lineAttributes.toString());
	}

	@Test
	public void strokeLinecap_butt() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinecap("butt");
		assertEquals("stroke-linecap:butt; ", lineAttributes.toString());
	}

	@Test
	public void strokeLinecap_Round() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinecap("round");
		assertEquals("stroke-linecap:round; ", lineAttributes.toString());
	}

	@Test
	public void strokeLinecap_middle() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinecap("middle");
		assertEquals("stroke-linecap:round; ", lineAttributes.toString());
	}

	@Test
	public void strokeLinecap_Square() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinecap("square");
		assertEquals("stroke-linecap:square; ", lineAttributes.toString());
	}

	@Test
	public void strokeLinecap_Long() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinecap("long");
		assertEquals("stroke-linecap:square; ", lineAttributes.toString());
	}

	@Test
	public void strokeLineJoin_default() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinejoin();
		assertEquals("stroke-linejoin:miter; ", lineAttributes.toString());
	}

	@Test
	public void strokeLineJoin_undefind() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinejoin("SomthingWrong");
		assertEquals("stroke-linejoin:miter; ", lineAttributes.toString());
	}

	@Test
	public void strokeLineJoin_miter() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinejoin("miter");
		assertEquals("stroke-linejoin:miter; ", lineAttributes.toString());
	}

	@Test
	public void strokeLineJoin_spiky() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinejoin("spiky");
		assertEquals("stroke-linejoin:miter; ", lineAttributes.toString());
	}

	@Test
	public void strokeLineJoin_bevel() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinejoin("bevel");
		assertEquals("stroke-linejoin:bevel; ", lineAttributes.toString());
	}

	@Test
	public void strokeLineJoin_flat() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinejoin("flat");
		assertEquals("stroke-linejoin:bevel; ", lineAttributes.toString());
	}

	@Test
	public void strokeLineJoin_round() {
		LineAttributes lineAttributes = new LineAttributes();
		lineAttributes.strokeLinejoin("round");
		assertEquals("stroke-linejoin:round; ", lineAttributes.toString());
	}

}

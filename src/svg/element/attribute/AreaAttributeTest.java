package svg.element.attribute;

import static org.junit.Assert.*;

import org.junit.Test;

import svg.element.attribute.property.Unit;

public class AreaAttributeTest {

	@Test
	public void TestCallsetAreaWith_width_height_unit() {
		AreaAttribute areaAttribute = new AreaAttribute();
		areaAttribute.setArea(111, 222, new Unit("ext"));
		assertEquals("width='111ext' height='222ext' ", areaAttribute.toString());
	}

	@Test
	public void TestCallsetAreaWith_width_height() {
		AreaAttribute areaAttribute = new AreaAttribute();
		areaAttribute.setArea(321, 654);
		assertEquals("width='321px' height='654px' ", areaAttribute.toString());
	}

	@Test
	public void TestCallsetAreaWith_oneSize_Unit() {
		AreaAttribute areaAttribute = new AreaAttribute();
		areaAttribute.setArea(123, new Unit("pt"));
		assertEquals("width='123pt' height='123pt' ", areaAttribute.toString());
	}
	
	@Test
	public void TestCallsetAreaWith_oneSize() {
		AreaAttribute areaAttribute = new AreaAttribute();
		areaAttribute.setArea(456);
		assertEquals("width='456px' height='456px' ", areaAttribute.toString());
	}
}

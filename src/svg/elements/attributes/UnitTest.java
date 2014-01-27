package svg.elements.attributes;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTest {

	@Test
	public void call_GetWithUnit_WithIntAndChangeUnit() {
		Unit unit = new Unit();
		unit.setUnitAbbreviation("pt");
		String result = unit.getWithUnit(1);
		assertEquals("1pt", result);
	}

	@Test
	public void call_GetWithUnit_WithString() {
		Unit unit = new Unit();
		String result = unit.getWithUnit("helloWorld");
		assertEquals("helloWorldpx", result);
	}

	@Test
	public void call_GetWithUnit_WithInt() {
		Unit unit = new Unit();
		String result = unit.getWithUnit(3);
		assertEquals("3px", result);
	}

	@Test
	public void call_GetWithUnit_WithFloat() {
		Unit unit = new Unit();
		String result = unit.getWithUnit(1.2f);
		assertEquals("1.2px", result);
		result = unit.getWithUnit(2.34f);
		assertEquals("2.34px", result);
		result = unit.getWithUnit(3.45f);
		assertEquals("3.45px", result);
	}

}

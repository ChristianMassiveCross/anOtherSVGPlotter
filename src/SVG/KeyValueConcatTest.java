package SVG;

import static org.junit.Assert.*;

import org.junit.Test;

public class KeyValueConcatTest {

	@Test
	public void defaultUse() {
		KeyValueConcat obj = new KeyValueConcat("key", "value");
		assertEquals("key='value' ", obj.toString());
	}

	@Test
	public void changeConnectorAndQoute() {
		KeyValueConcat obj = new KeyValueConcat("key", "value");
		obj.setConnector(":");
		obj.setValueQuotes("");
		assertEquals("key:value ", obj.toString());
	}

}

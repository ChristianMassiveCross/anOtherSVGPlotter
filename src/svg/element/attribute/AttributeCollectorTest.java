package svg.element.attribute;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttributeCollectorTest {

	@Test
	public void normalAttributeCollector() {
		AttributeCollector attributeCollector = new AttributeCollector();
		attributeCollector.addToCollector("Hello World!");
		attributeCollector.addToCollector(", are you ");
		attributeCollector.addToCollector("fine?");
		assertEquals(
				"Hello World!, are you fine?",
				attributeCollector.toString()
		);
	}
	@Test
	public void zeroAttributeCollector() {
		AttributeCollector attributeCollector = new AttributeCollector();
		assertEquals( "", attributeCollector.toString() );
	}

}

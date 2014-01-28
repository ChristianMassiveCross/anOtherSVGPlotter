package svg.elements.attributes;

import java.util.Iterator;
import java.util.Vector;

public class AttributeCollector {

	private Vector<String> collectedAttributes;

	public AttributeCollector() {
		this.setCollectedAttributes(new Vector<String>());
	}
	
	@Override
	public String toString() {
		String path = "";
		for (Iterator<String> it = this.getCollectedAttributes().iterator(); it
				.hasNext();) {
			path = path.concat(it.next());
		}
		return path;
	}
	
	private Vector<String> getCollectedAttributes() {
		return collectedAttributes;
	}
	
	private void setCollectedAttributes(Vector<String> collectedAttributes) {
		this.collectedAttributes = collectedAttributes;
	}

	public void addToCollector(String part) {
		this.getCollectedAttributes().add(part);
	}
}

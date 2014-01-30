package svg.element.attribute;

import svg.element.attribute.property.Unit;

public class AreaAttribute extends AttributeCollector {
	
	public void setArea(int edgeLength) {
		this.setArea(edgeLength, edgeLength);
	}
	
	public void setArea(int edgeLength , Unit unit) {
		this.setArea(edgeLength, edgeLength, unit);
	}
	
	public void setArea(int width, int height) {
		Unit unit = new Unit();
		this.setArea(width, height, unit);
	}
	
	public void setArea(int width, int height, Unit unit) {
		String pattern = "width='%s' height='%s' ";
		String formatedString = String.format(
				pattern,
				unit.getWithUnit(width),
				unit.getWithUnit(height)
		);
		this.addToCollector(formatedString);
	}

}

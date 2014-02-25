package svg.element.attribute;

import java.awt.Point;

import svg.element.attribute.property.Unit;

public class CirclePositionAttribute extends AttributeCollector {
	
	public void setPosition(Point position) {
		Unit unit = new Unit();
		this.setPosition(position, unit);
	}
	
	public void setPosition(Point position, Unit unit) {
		String pattern = "cx='%s' cy='%s'";
		String formatedString = String.format(
				pattern, 
				unit.getWithUnit(position.x), 
				unit.getWithUnit(position.y)
		);
		this.addToCollector(formatedString);
	}

}

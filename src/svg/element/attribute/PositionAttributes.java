package svg.element.attribute;

import java.awt.Point;

import svg.element.attribute.property.Unit;

public class PositionAttributes extends AttributeCollector {
	
	public void setPosition(Point position) {
		Unit unit = new Unit();
		this.setPosition(position, unit);
	}
	
	public void setPosition(Point position, Unit unit) {
		String pattern = "x='%s' y='%s' ";
		String formatedString = String.format(
				pattern, 
				unit.getWithUnit(position.x), 
				unit.getWithUnit(position.y)
		);
		this.addToCollector(formatedString);
	}

}

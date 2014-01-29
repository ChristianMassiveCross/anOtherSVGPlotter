package svg.element.attribute;

import java.awt.Point;

public class LineAttributes extends AttributeCollector{
	public void setStartAndEndPoint(Point start, Point end) {
		String pattern = "x1='%d' y1='%d' x2='%d' y2='%d' ";
		String formatedString = String.format(
				pattern,
				start.x,
				start.y,
				end.x,
				end.y
		);
		this.addToCollector(formatedString);
	}
}

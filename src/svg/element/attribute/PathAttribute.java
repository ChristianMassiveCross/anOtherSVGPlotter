package svg.element.attribute;

import java.awt.Point;

public class PathAttribute extends AttributeCollector{

	public void moveTo(Point position) {
		String pattern = "M %d %d ";
		String formatedString = String.format(
				pattern,
					position.x,
					position.y
		);
		this.addToCollector(formatedString);
	}

	public void lineTo(Point position) {
		String pattern = "L %d %d ";
		String formatedString = String.format(
				pattern,
					position.x,
					position.y
		);
		this.addToCollector(formatedString);
	}

	public void curveTo(Point firstHandle, Point secondHandle, Point position) {
		String pattern = "C %d %d %d %d %d %d ";
		String bezierCurve = String.format(
				pattern,
					firstHandle.x, firstHandle.y,
					secondHandle.x, secondHandle.y,
					position.x, position.y
		);
		this.addToCollector(bezierCurve);
	}

	public void smoothCurveTo(Point handle, Point position) {
		String pattern = "S %d %d %d %d ";
		String smoothBezierCurve = String.format(
				pattern,
					handle.x, handle.y,
					position.x, position.y
		);
		this.addToCollector(smoothBezierCurve);
	}

	public void closePath() {
		this.addToCollector("Z ");
	}

}

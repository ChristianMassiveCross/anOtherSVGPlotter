package SVG;

import java.awt.Point;

public class PathAttributes {

	public String moveTo(Point position) {
		return String.format("M %d %d ", position.x, position.y);
	}

	public String lineTo(Point position) {
		return String.format("L %d %d ", position.x, position.y);
	}

	public String curveTo(Point firstHandle, Point secondHandle, Point position) {
		String bezierCurve = String.format("C %d %d %d %d %d %d ",
				firstHandle.x, firstHandle.y,
				secondHandle.x, secondHandle.y,
				position.x, position.y);
		return bezierCurve;
	}

	public String smoothCurveTo(Point handle, Point position) {
		String smoothBezierCurve = String.format("S %d %d %d %d ",
				handle.x, handle.y,
				position.x, position.y
				);
		return smoothBezierCurve;
	}

	public String closePath() {
		return "Z ";
	}

}

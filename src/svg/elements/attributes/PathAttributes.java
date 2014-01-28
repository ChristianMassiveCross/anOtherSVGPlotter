package svg.elements.attributes;

import java.awt.Point;
import java.util.Iterator;
import java.util.Vector;

public class PathAttributes {
	private Vector<String> collectedPath;

	public PathAttributes() {
		this.setCollectedPath(new Vector<String>());
	}

	private void addToPath(String part) {
		this.getCollectedPath().add(part);
	}

	public void moveTo(Point position) {
		String pattern = "M %d %d ";
		String formatedString = String.format(
				pattern,
					position.x,
					position.y
		);
		this.addToPath(formatedString);
	}

	public void lineTo(Point position) {
		String pattern = "L %d %d ";
		String formatedString = String.format(
				pattern,
					position.x,
					position.y
		);
		this.addToPath(formatedString);
	}

	public void curveTo(Point firstHandle, Point secondHandle, Point position) {
		String pattern = "C %d %d %d %d %d %d ";
		String bezierCurve = String.format(
				pattern,
					firstHandle.x, firstHandle.y,
					secondHandle.x, secondHandle.y,
					position.x, position.y
		);
		this.addToPath(bezierCurve);
	}

	public void smoothCurveTo(Point handle, Point position) {
		String pattern = "S %d %d %d %d ";
		String smoothBezierCurve = String.format(
				pattern,
					handle.x, handle.y,
					position.x, position.y
		);
		this.addToPath(smoothBezierCurve);
	}

	public void closePath() {
		this.addToPath("Z ");
	}

	@Override
	public String toString() {
		String path = "";
		for (Iterator<String> it = this.getCollectedPath().iterator(); it
				.hasNext();) {
			path = path.concat(it.next());
		}
		return path;
	}

	private Vector<String> getCollectedPath() {
		return collectedPath;
	}

	private void setCollectedPath(Vector<String> collectedPath) {
		this.collectedPath = collectedPath;
	}

}

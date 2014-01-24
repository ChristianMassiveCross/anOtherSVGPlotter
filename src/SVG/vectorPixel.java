package SVG;

import java.awt.Point;
import java.util.Vector;

public class vectorPixel {
	private Vector<Point> point;
	public vectorPixel(Point point) {
		this.setPoint(point);
	}
	public Vector<Point> getPoint() {
		return point;
	}
	public void setPoint(Vector<Point> point) {
		this.point = point;
	}
	
}

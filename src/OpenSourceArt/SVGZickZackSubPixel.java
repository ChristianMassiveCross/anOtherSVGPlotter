package OpenSourceArt;

import java.awt.Point;
import java.util.Vector;

public class SVGZickZackSubPixel {
	private Point startPoint;
	private Point endPoint;
	private int height;
	private int width;
	private int zickZackAmount;
	private Vector<Point> subPixelPoints;

	public SVGZickZackSubPixel(int zickZackAmount) {
		this.setZickZackAmount(zickZackAmount);
	}

	public String get(Point startPoint, Point endPoint) {
		this.init(startPoint, endPoint);
		this.createStartSubPixel();
		this.createEndSubPixel();

		return this.buildSVGPath();
	}

	private String buildSVGPath() {
		return this.getSubPixelPoints().toString();
	}

	private void init(Point startPoint, Point endPoint) {
		this.setStartPoint(startPoint);
		this.setEndPoint(endPoint);
		this.setWidth(endPoint.x - startPoint.x);
		this.setHeight(endPoint.y - startPoint.y);
		this.setSubPixelPoints(new Vector<Point>());
	}

	private void createStartSubPixel() {
		int x = this.getStartPoint().x;
		int y = this.getHeight() / 2;
		this.getSubPixelPoints().add(new Point(x, y));
	}

	private void createEndSubPixel() {
		int x = this.getEndPoint().x;
		int y = this.getHeight() / 2;
		this.getSubPixelPoints().add(new Point(x, y));
	}

	/* getter setter */
	private Point getStartPoint() {
		return startPoint;
	}

	private void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	private Point getEndPoint() {
		return endPoint;
	}

	private void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	private int getZickZackAmount() {
		return zickZackAmount;
	}

	private void setZickZackAmount(int zickZackAmount) {
		this.zickZackAmount = zickZackAmount;
	}

	private Vector<Point> getSubPixelPoints() {
		return subPixelPoints;
	}

	private void setSubPixelPoints(Vector<Point> subPixelPoints) {
		this.subPixelPoints = subPixelPoints;
	}

	private int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	private int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		this.width = width;
	}
}

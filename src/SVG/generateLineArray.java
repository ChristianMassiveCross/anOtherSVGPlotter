package SVG;

import java.awt.Point;
import java.util.Vector;

public class generateLineArray {
	@SuppressWarnings("unused")
	private int[] oneLineOfPixels;
	private int amountOfDivisions = 0;
	private Point sizeCanvas;
	int borderLeft = 0;
	int borderRight = 0;
	int borderTop = 0;
	int borderBottom = 0;

	public generateLineArray(Point sizeCanvas) {
		this.setSizeCanvas(sizeCanvas);
		int[] defaultPixelArray = new int[1];
		defaultPixelArray[0] = 1;
		this.setOneLinePixel(defaultPixelArray);
	}

	public void setOneLinePixel(int[] oneLinePixel) {
		this.oneLineOfPixels = oneLinePixel;
	}

	public Vector<Point> getLine() {
		Vector<Point> Line = new Vector<Point>();
		// start point
		Line.addElement(new Point(this.borderLeft, (this.borderBottom / 2)));
		// middle points
		Line = this.extendsMiddlePoints(Line);
		// endPoint
		Line.addElement(new Point(this.borderRight, (this.borderBottom / 2)));

		return Line;
	}

	private Vector<Point> extendsMiddlePoints(Vector<Point> Line) {
		int sectionWith = this.borderRight / this.getAmountOfSections();
		int sectionsPerStep = 2;
		boolean isTopPosition = true; 
		for ( int i = 1;i < this.getAmountOfSections(); i += sectionsPerStep) {
			int startSection = i;
			if (isTopPosition){
				Line.addElement(new Point((sectionWith * startSection), this.borderTop));
				isTopPosition = false;
			}else {
				Line.addElement(new Point((sectionWith * startSection), this.borderBottom));
				isTopPosition = true;
			}
		}
		return Line;
	}
	private int getAmountOfSections () {
		return this.getAmountOfDivisions() * 4;
	}
	private int getAmountLineKnotes() {
		final int startPoint = 1;
		final int endPoint = 1;
		int middlePoints = this.getAmountOfDivisions() * 2;
		return startPoint + endPoint + middlePoints;
	}

	// setter getter
	private Point getSizeCanvas() {
		return this.sizeCanvas;
	}

	private void setSizeCanvas(Point sizeCanvas) {
		this.sizeCanvas = sizeCanvas;
		this.borderRight = sizeCanvas.x;
		this.borderBottom = sizeCanvas.y;
	}

	public int getAmountOfDivisions() {
		return this.amountOfDivisions;
	}

	public void setAmountOfDivisions(int amountOfDivisions) {
		this.amountOfDivisions = amountOfDivisions;
	}

}

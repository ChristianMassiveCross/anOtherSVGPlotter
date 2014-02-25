package OpenSourceArt;

import java.awt.Point;

import svg.element.Circle;
import svg.element.attribute.CirclePositionAttribute;
import svg.element.attribute.StyleAttribute;
import svg.element.attribute.property.Color;

import image.raster.attribute.Pixel;

public class CircleEngine {

	private Pixel[][] pixelMatrix;
	private Point tileSize;

	public CircleEngine(Pixel[][] pixelMatrix, Point tileSize) {
		this.setPixelMatrix(pixelMatrix);
		this.setTileSize(tileSize);

	}

	public CircleEngine(Pixel[][] pixelMatrix) {
		this.setPixelMatrix(pixelMatrix);
		this.setTileSize(new Point(1, 1));
	}

	public String createPixel(Point position) {
		Pixel pixel = this.getPixelMatrix()[position.x][position.y];
		String collectString = 
				this.createCirclesInPixel(
						position, 
						pixel.red(),
						new Color(255,0,0),
						0.399f
				);
		collectString = collectString.concat(
				this.createCirclesInPixel(
						position,
						pixel.green(),
						new Color(0,255,0),
						0.487f
				));
		collectString = collectString.concat(
				this.createCirclesInPixel(
						position,
						pixel.blue(),
						new Color(0,0,255),
						0.114f
				));
		return collectString;
	}

	private String createCirclesInPixel(Point position, int pixelFactor, Color CircleColor, float factor) {
		int Radius = 10;
		StyleAttribute style = new StyleAttribute();
		style.fill(new Color());
		style.stroke(CircleColor);
		style.strokeWidth(0.2f);
		String outputString = "";
		for (int i = 0; i < (pixelFactor*factor)/5; i++) {
			Point positionInSVG = this.mapPositionToCanvasSize(position);
			CirclePositionAttribute circlePosition = new CirclePositionAttribute();
			circlePosition.setPosition(positionInSVG);
			Circle circle = new Circle(circlePosition, Radius, style);
			outputString = outputString.concat(circle.getAsString());
		}
		return outputString;
	}

	private Point mapPositionToCanvasSize(Point positionInPNG) {
		int XpositionInSVG = this.getTileSize().x * positionInPNG.x;
		int YpositionInSVG = this.getTileSize().y * positionInPNG.y;
		// randomPositionInTile
		int randomXShift = (int) (Math.random() * this.getTileSize().x);
		int randomYShift = (int) (Math.random() * this.getTileSize().y);
		// shift
		XpositionInSVG += randomXShift;
		YpositionInSVG += randomYShift;

		return new Point(XpositionInSVG, YpositionInSVG);
	}

	private Pixel[][] getPixelMatrix() {
		return pixelMatrix;
	}

	private void setPixelMatrix(Pixel[][] pixelMatrix) {
		this.pixelMatrix = pixelMatrix;
	}

	private Point getTileSize() {
		return tileSize;
	}

	private void setTileSize(Point tileSize) {
		this.tileSize = tileSize;
	}

}

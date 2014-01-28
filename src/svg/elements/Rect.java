package svg.elements;

import java.awt.Point;

import svg.elements.attributes.StyleAttributes;
import svg.elements.attributes.properties.Color;

import SVG.KeyValuePixel;

public class Rect implements GraficElement {
	private StyleAttributes style;
	private Point size = null;
	Point position;
	public Rect(Point position, Point size) {
		this.position = position;
		this.size = size;
	}
	@Override
	public String getAsString() {
		String outPut = "<rect ";
		outPut = outPut.concat(this.createPosition(position));
		outPut = outPut.concat(this.createSize(size));
		outPut = outPut.concat(this.getStyle());
		outPut = outPut.concat(" />");
		return outPut;
	}

	private String createSize(Point size) {
		String xSize = this.int2String(this.size.x);
		KeyValuePixel xSizeValue = new KeyValuePixel("width", xSize);

		String ySize = this.int2String(this.size.y);
		KeyValuePixel ySizeValue = new KeyValuePixel("height", ySize);

		String outPut = "";
		outPut = outPut.concat(xSizeValue.toString());
		outPut = outPut.concat(ySizeValue.toString());

		return outPut;
	}

	private String createPosition(Point position) {
		String xValue = this.int2String(position.x * this.size.x);
		KeyValuePixel xKeyValue = new KeyValuePixel("x", xValue);

		String yValue = this.int2String(position.y * this.size.y);
		KeyValuePixel yKeyValue = new KeyValuePixel("y", yValue);

		String outPut = "";
		outPut = outPut.concat(xKeyValue.toString());
		outPut = outPut.concat(yKeyValue.toString());

		return outPut;
	}

	private String getStyle() {
		return this.style.getAsString();
	}

	public void setStyle(Color Fillcolors) {
		this.setStyle(Fillcolors, Fillcolors);
	}

	public void setStyle(Color Fillcolors, Color StrokeColor) {
		StyleAttributes style = new StyleAttributes();
		style.setFillColor(Fillcolors);
		style.setStokeColor(StrokeColor);
		this.style = style;
	}

	public String int2String(int integer) {
		Integer meinInteger = new Integer(integer);
		return meinInteger.toString();
	}

}

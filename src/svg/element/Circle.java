package svg.element;

import svg.element.attribute.CirclePositionAttribute;
import svg.element.attribute.StyleAttribute;

public class Circle implements GraficElement {
	private CirclePositionAttribute position;
	private int Radius;
	private StyleAttribute style;
public Circle(CirclePositionAttribute position, int Radius, StyleAttribute style) {
	this.setPosition(position);
	this.setRadius(Radius);
	this.setStyle(style);
}
	public Circle(CirclePositionAttribute position, int Radius) {
		this.setPosition(position);
		this.setRadius(Radius);
		this.setStyle(new StyleAttribute());
	}

	@Override
	public String getAsString() {
		String pattern = "<circle %s />";
		String attributes = this.getAttributes();
		String pathAsString = String.format(pattern, attributes);
		return pathAsString;

	}

	private String getAttributes() {
		String pattern = "%s %s %s";
		String formatedString = String.format(
				pattern,
				this.getPosition(),
				this.getRadius(),
				this.getStyle()
				);
		return formatedString;
	}

	private String getPosition() {
		return position.toString();
	}

	private void setPosition(CirclePositionAttribute position) {
		this.position = position;
	}

	private String getRadius() {
		String pattern = "r='%d'";
		return String.format(pattern, this.Radius);
	}

	private void setRadius(int radius) {
		Radius = radius;
	}
	private String getStyle() {
		return style.toString();
	}
	private void setStyle(StyleAttribute style) {
		this.style = style;
	}

}

package svg.element;

import svg.element.attribute.AreaAttribute;
import svg.element.attribute.PositionAttribute;
import svg.element.attribute.StyleAttribute;

public class Rect implements GraficElement {
	private StyleAttribute style;
	private PositionAttribute position;
	private AreaAttribute area;

	public Rect(PositionAttribute position, AreaAttribute area, StyleAttribute style) {
		this.setPosition(position);
		this.setArea(area);
		this.setStyle(style);
	}

	@Override
	public String getAsString() {
		String pattern = "<rect %s />";
		String attributes = this.getAttributes();
		String pathAsString = String.format(pattern, attributes);
		return pathAsString;
	}

	private String getAttributes() {
		String pattern =  "%s %s %s";
		String formatedString = String.format(
				pattern,
				this.getPosition(),
				this.getArea(),
				this.getStyle()
		);
		return formatedString;
	}

	private String getStyle() {
		return style.toString();
	}

	private void setStyle(StyleAttribute style) {
		this.style = style;
	}

	private String getPosition() {
		return position.toString();
	}

	private void setPosition(PositionAttribute position) {
		this.position = position;
	}

	private String getArea() {
		return area.toString();
	}

	private void setArea(AreaAttribute area) {
		this.area = area;
	}

}

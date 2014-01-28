package svg.elements.attributes;

import svg.elements.attributes.properties.Color;
import svg.elements.attributes.properties.Unit;

public class StyleAttributes extends AttributeCollector{
	
	public void fill(Color color) {
		String pattern = "fill:%s; ";
		String formatedString = String.format(pattern, color.toString());
		this.addToCollector(formatedString);
	}

	public void stroke(Color color) {
		String pattern = "stroke:%s; ";
		String formatedString = String.format(pattern, color.toString());
		this.addToCollector(formatedString);
	}

	public void strokeWidth(float width) {
		Unit unit = new Unit();
		this.strokeWidth(width, unit);
	}

	public void strokeWidth(float width, Unit unit) {
		String pattern = "stroke-width:%s; ";
		String formatedString = String.format(pattern, unit.getWithUnit(width));
		this.addToCollector(formatedString);
	}

	private String opacityToString(int opacityInProcent) {
		Float opacity = opacityInProcent / 100.f;
		return opacity.toString();
	}

	public void strokeOpacity(int opacityInProcent) {
		String pattern = "stroke-opacity:%s; ";
		String opacityAsString = this.opacityToString(opacityInProcent);
		String formatedString = String.format(pattern, opacityAsString);
		this.addToCollector(formatedString);
	}

	public void fillOpacity(int opacityInProcent) {
		String pattern = "fill-opacity:%s; ";
		String opacityAsString = this.opacityToString(opacityInProcent);
		String formatedString = String.format(pattern, opacityAsString);
		this.addToCollector(formatedString);
	}

}
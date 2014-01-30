package svg.element;

import svg.element.attribute.PathAttribute;
import svg.element.attribute.StyleAttribute;

public class Path implements GraficElement {
	private String pathAttributes = "";
	private String style = "";

	@Override
	public String getAsString() {
		String pattern = "<path %s />";
		String attributes = this.getAttributes();
		String pathAsString = String.format(pattern, attributes);
		return pathAsString;
	}
	
	private String getAttributes() {
		String pattern =  "%s %s";
		String formatedString = String.format(
				pattern,
				this.getPathAttributes(),
				this.getStyle()
		);
		return formatedString;
	}
	
	private String getPathAttributes() {
		return pathAttributes;
	}

	public void setPathAtributes(PathAttribute pathAtributes) {
		this.pathAttributes = pathAtributes.toString();
	}

	private String getStyle() {
		return style;
	}

	public void setStyle(StyleAttribute styleAttributes) {
		this.style = styleAttributes.toString();
	}

}

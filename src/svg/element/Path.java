package svg.element;

import svg.element.attribute.PathAttribute;
import svg.element.attribute.StyleAttribute;

public class Path implements GraficElement {
	private String pathAttributes = "";
	private String style = "";

	@Override
	public String getAsString() {
		String pattern = "<path d='%s' %s/>";
		String path = this.getPathAttributes();
		String style = this.getStyle();
		String pathAsString = String.format(pattern, path, style);
		return pathAsString;
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

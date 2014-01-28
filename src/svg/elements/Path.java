package svg.elements;

import svg.elements.attributes.PathAttributes;
import svg.elements.attributes.StyleAttributes;

public class Path implements GraficElement {
	private String pathAttributes = "";
	private String style = "";

	@Override
	public String getAsString() {
		String pattern = "<path d='%s' style='%s'/>";
		String path = this.getPathAttributes();
		String style = this.getStyle();
		String pathAsString = String.format(pattern, path, style);
		return pathAsString;
	}

	private String getPathAttributes() {
		return pathAttributes;
	}

	public void setPathAtributes(PathAttributes pathAtributes) {
		this.pathAttributes = pathAtributes.toString();
	}

	private String getStyle() {
		return style;
	}

	public void setStyle(StyleAttributes styleAttributes) {
		this.style = styleAttributes.toString();
	}

}

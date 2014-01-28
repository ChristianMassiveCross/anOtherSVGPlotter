package svg.elements;

import svg.elements.attributes.PathAttributes;
import svg.elements.attributes.StyleAttributes;

public class Path implements GraficElement {
	private String pathAtributes = "";
	private String style = "";

	@Override
	public String getAsString() {
		String pattern = "<path d='%s' style='%s'/>";
		String path = this.getPathAtributes();
		String style = this.getStyle();
		String pathAsString = String.format(pattern, path, style);
		return pathAsString;
	}

	private String getPathAtributes() {
		return pathAtributes;
	}

	public void setPathAtributes(PathAttributes pathAtributes) {
		this.pathAtributes = pathAtributes.toString();
	}

	private String getStyle() {
		return style;
	}

	public void setStyle(StyleAttributes styleAttributes) {
		this.style = styleAttributes.toString();
	}

}

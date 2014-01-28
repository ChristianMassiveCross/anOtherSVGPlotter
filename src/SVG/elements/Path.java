package SVG.elements;

import svg.elements.attributes.PathAttributes;

public class Path implements GraficElement{
	private String pathAtributes = "";
	private String style = "";
	@Override
	public String getAsString() {
		String elementPattern = "<path d='%s' style='%s'/>";
		String coordinates = this.getPathAtributes();
		String style = this.getStyle();
		String path = String.format(elementPattern, coordinates, style);
		return path;
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
	public void setStyle(String style) {
		this.style = style;
	}

}

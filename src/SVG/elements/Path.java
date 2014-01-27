package SVG.elements;

public class Path implements GraficElement{
	private String coordinates = "";
	private String style = "";
	@Override
	public String getAsString() {
		String elementPattern = "<path d='%s' style='%s'/>";
		String coordinates = this.getCoordinates();
		String style = this.getStyle();
		String path = String.format(elementPattern, coordinates, style);
		return path;
	}
	private String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	private String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}

}

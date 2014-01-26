package SVG;

public class Color {
	// final static
	final static String TRANSPARENT = "none";
	final static String BLACK = "#000000";
	final static String WHITE = "#FFFFFF";
	private String colorString;
	public Color() {
		this.setColorString(TRANSPARENT);
	}
	public Color(int grey) {
		this.setColorString("rgb(" + grey + "," + grey + "," + grey + ")");
	}
	public Color(int red, int blue, int green) {
		this.setColorString("rgb(" + red + "," + blue + "," + green + ")");
	}
	
	public String getColorString() {
		return colorString;
	}
	private void setColorString(String color) {
		this.colorString = color;
	}
}

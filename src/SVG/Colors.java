package SVG;

public class Colors {
	// final static
	final static String TRANSPARENT = "none";
	final static String BLACK = "#000000";
	final static String WHITE = "#FFFFFF";
	private String colorString;
	public Colors() {
		this.setColorString(TRANSPARENT);
	}
	public Colors(int grey) {
		this.setColorString("rgb(" + grey + "," + grey + "," + grey + ")");
	}
	public Colors(int red, int blue, int green) {
		this.setColorString("rgb(" + red + "," + blue + "," + green + ")");
	}
	
	public String getColorString() {
		return colorString;
	}
	private void setColorString(String color) {
		this.colorString = color;
	}
}

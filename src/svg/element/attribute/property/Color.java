package svg.element.attribute.property;

public class Color {
	// final static
	final static String TRANSPARENT = "none";
	private String colorString;

	public Color() {
		this.setColorString(TRANSPARENT);
	}

	public Color(int grey) {
		this.setColorStringRGB(grey, grey, grey);
	}

	public Color(int red, int blue, int green) {
		this.setColorStringRGB(red, blue, green);
	}

	@Override
	public String toString() {
		return this.colorString;
	}
	
	private void setColorString(String colorString) {
		this.colorString = colorString;
	}

	private void setColorStringRGB(int red, int blue, int green) {
		String rgbPattern = "rgb(%d,%d,%d)";
		this.setColorString(
				String .format(
					rgbPattern,
					red, blue, green
				)
		);
	}
}

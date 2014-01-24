package SVG;

public class StyleAttributes {
	// final static
	final static String TRANSPARENT = "none";
	final static String BLACK = "#000000";
	final static String WHITE = "#FFFFFF";
	// classVars with defaults
	private String fillColor = TRANSPARENT;
	private String stokeColor = BLACK;
	private String strokeWidth = "1.0";
	private String strokeLinecap = "round";
	private String strokeLinejoin = "round";

	public StyleAttributes() {

	}

	public String getAsString() {
		String styleString = "";
		styleString = styleString.concat("style='");
		styleString = styleString.concat(this.getFillColor());
		styleString = styleString.concat(this.getStokeColor());
		styleString = styleString.concat("' ");
		return styleString;
	}

	private String concatKeyValue(String key, String value) {
		KeyValueConcat kvc = new KeyValueConcat(key, value);
		kvc.setConnector(":");
		kvc.setValueQuotes("");
		return kvc.toString();
	}

	// -------------------------------------------------------------------------
	public String getFillColor() {
		return concatKeyValue("fill", this.fillColor);
	}

	public void setFillColor(String fillcolor) {
		this.fillColor = fillColor;
	}

	public void setFillColor(Colors color) {
		this.fillColor = color.getColorString();
	}

	// -------------------------------------------------------------------------
	public String getStokeColor() {
		return concatKeyValue("stroke", this.stokeColor);
	}

	public void setStokeColor(String stokeColor) {
		this.stokeColor = stokeColor;
	}

	public void setStokeColor(Colors color) {
		this.stokeColor = color.getColorString();
	}

	// -------------------------------------------------------------------------
	public String getStrokeWidth() {
		return concatKeyValue("stroke-width", this.strokeWidth);
	}

	public void setStrokeWidth(String strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

	// -------------------------------------------------------------------------
	public String getStrokeLinecap() {
		return concatKeyValue("stroke-linecap", this.strokeLinecap);
	}

	public void setStrokeLinecap(String strokeLinecap) {
		this.strokeLinecap = strokeLinecap;
	}

	// -------------------------------------------------------------------------
	public String getStrokeLinejoin() {
		return concatKeyValue("stroke-linejoin", this.strokeLinejoin);
	}

	public void setStrokeLinejoin(String strokeLinejoin) {
		this.strokeLinejoin = strokeLinejoin;
	}
}

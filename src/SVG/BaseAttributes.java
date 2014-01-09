package SVG;

public class BaseAttributes{
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
	
	public BaseAttributes () {
		
	}
	private String formatElement (String key, String value){
		return key.concat(":").concat(value).concat(";");
	}
	//-------------------------------------------------------------------------
	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
	
	//-------------------------------------------------------------------------
	public String getStokeColor() {
		return formatElement("stroke",this.stokeColor);
	}

	public void setStokeColor(String stokeColor) {
		this.stokeColor = stokeColor;
	}
	
	//-------------------------------------------------------------------------
	public String getStrokeWidth() {
		return formatElement("stroke-width",this.strokeWidth);
	}

	public void setStrokeWidth(String strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

	//-------------------------------------------------------------------------
	public String getStrokeLinecap() {
		return formatElement("stroke-linecap",this.strokeLinecap);
	}
	public void setStrokeLinecap(String strokeLinecap) {
		this.strokeLinecap = strokeLinecap;
	}

	//-------------------------------------------------------------------------
	public String getStrokeLinejoin() {
		return formatElement("stroke-linejoin",this.strokeLinejoin);
	}

	public void setStrokeLinejoin(String strokeLinejoin) {
		this.strokeLinejoin = strokeLinejoin;
	}
}

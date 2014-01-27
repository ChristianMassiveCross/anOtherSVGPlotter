package svg.elements.attributes;

public class StyleAttributes {

	// stroke-linejoin

	public String fill(Color color) {
		return String.format("fill:%s; ", color.toString());
	}

	public String stroke(Color color) {
		return String.format("stroke:%s; ", color.toString());
	}

	public String strokeWidth(float width) {
		Unit unit = new Unit();
		return this.strokeWidth(width, unit);
	}

	public String strokeWidth(float width, Unit unit) {
		return String.format("stroke-width:%s; ", unit.getWithUnit(width));
	}

	private String opacityToString(int opacityInProcent) {
		Float opacity = opacityInProcent / 100.f;
		return opacity.toString();
	}

	public String strokeOpacity(int opacityInProcent) {
		String opacityAsString = this.opacityToString(opacityInProcent);
		return String.format("stroke-opacity:%s; ", opacityAsString);
	}

	public String fillOpacity(int opacityInProcent) {
		String opacityAsString = this.opacityToString(opacityInProcent);
		return String.format("fill-opacity:%s; ", opacityAsString);
	}

	public String strokeLinecap() {
		return this.strokeLinecap("butt");
	}

	public String strokeLinecap(String type) {
		String lineCap = "";
		switch (type) {
		case "round":
		case "middle":
			lineCap = "round";
			break;
		case "long":
		case "square":
			lineCap = "square";
			break;
		case "butt":
		case "short":
		default:
			lineCap = "butt";
			break;
		}
		return String.format("stroke-linecap:%s; ", lineCap);
	}

	public String strokeLinejoin() {
		return this.strokeLinejoin("miter");
	}

	public String strokeLinejoin(String type) {
		String lineJoin = "";
		switch (type) {
		case "round":
			lineJoin = "round";
			break;
		case "flat":
		case "bevel":
			lineJoin = "bevel";
			break;
		case "spiky":
		case "miter":
		default:
			lineJoin = "miter";
			break;
		}
		return String.format("stroke-linejoin:%s; ", lineJoin);
	}

}

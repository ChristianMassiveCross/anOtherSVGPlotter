package svg.elements.attributes;

public class StrokeAttributes extends AttributeCollector {
	
	public void strokeLinecap() {
		this.strokeLinecap("butt");
	}

	public void strokeLinecap(String type) {
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
		String pattern = "stroke-linecap:%s; ";
		String formatedString = String.format(pattern, lineCap);
		this.addToCollector(formatedString);
	}

	public void strokeLinejoin() {
		this.strokeLinejoin("miter");
	}

	public void strokeLinejoin(String type) {
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
		String pattern = "stroke-linejoin:%s; ";
		String formatedString = String.format(pattern, lineJoin);
		this.addToCollector(formatedString);
	}
}

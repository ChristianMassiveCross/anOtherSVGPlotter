package svg.element;

import java.awt.Point;

import svg.element.attribute.LineAttribute;
import svg.element.attribute.StyleAttribute;

public class Line implements GraficElement{
	Point startPoint = new Point();
	Point endPoint;
	private String position;
	private String style;
	
	@Override
	public String getAsString() {
		String pattern = "<line %s />";
		String attribute = this.getAttributes();
		String lineElement = String.format(pattern, attribute);
		return lineElement;
	}

	private String getAttributes() {
		String pattern = "%s %s";
		String formatedString = String.format(pattern, this.getPosition(),
				this.getStyle());
		return formatedString;
	}
	
	private String getPosition() {
		String returnValue;
		if ( this.position == null){
			returnValue = "";
		}else{
			returnValue = this.position;
		}
		return returnValue;
	}

	public void setPosition(LineAttribute lineAtributes) {
		this.position = lineAtributes.toString();
	}

	private String getStyle() {
		String returnValue;
		if ( this.style == null){
			returnValue = "";
		}else{
			returnValue = this.style;
		}
		return returnValue;
	}

	public void setStyle(StyleAttribute styleAttributes) {
		this.style = styleAttributes.toString();
	}

}

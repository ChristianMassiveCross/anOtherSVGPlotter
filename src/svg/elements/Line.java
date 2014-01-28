package svg.elements;

import java.awt.Point;

import svg.elements.attributes.LineAttributes;
import svg.elements.attributes.StyleAttributes;

public class Line implements GraficElement{
	Point startPoint = new Point();
	Point endPoint;
	private String position;
	private String style;
	
	@Override
	public String getAsString() {
		String pattern = "<line %s style='%s'/>";
		String startAndEndPoint = this.getPosition();
		String style = this.getStyle();
		String pathAsString = String.format(pattern, startAndEndPoint, style);
		return pathAsString;
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

	public void setPosition(LineAttributes lineAtributes) {
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

	public void setStyle(StyleAttributes styleAttributes) {
		this.style = styleAttributes.toString();
	}

}

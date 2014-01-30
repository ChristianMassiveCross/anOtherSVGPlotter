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

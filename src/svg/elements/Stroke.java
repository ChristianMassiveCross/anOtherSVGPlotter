package svg.elements;

import java.awt.Point;

import svg.elements.attributes.StyleAttributes;


public class Stroke implements GraficElement{
	StyleAttributes attributes;
	Point startPoint = new Point();
	Point endPoint;
	public Stroke(StyleAttributes attributes) {
		this.attributes = attributes;
	}

	public String getAsString() {
		String OutPut = "<line ";
		OutPut += this.getPosition();
		OutPut += this.getStyle();
		OutPut += "/>";
		return OutPut;
	}
	
	public String getPosition (){
		String position = "";
		position += this.formatPositionElement("x1",this.startPoint.x);
		position += this.formatPositionElement("y1",this.startPoint.y);
		position += this.formatPositionElement("x2",this.endPoint.x);
		position += this.formatPositionElement("y2",this.endPoint.y);
		return position;
	}
	
	private String formatPositionElement (String key, int value){
		Integer valueAsInteger = new Integer(value);
        String valueAsString = valueAsInteger.toString(); 
		return key.concat("='").concat(valueAsString).concat("' ");
	}
	
	public String getStyle() {
		String style = "style='";
		style += attributes.getStokeColor();
		style += attributes.getStrokeWidth();
		style += attributes.getStrokeLinecap();
		style += "'";
		return style;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}


}

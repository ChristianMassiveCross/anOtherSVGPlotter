package FirstTry;
import java.awt.Point;

import svg.elements.Line;
import svg.elements.attributes.StyleAttributes;

import SVG.CanvasSpliter;
import SVG.Creator;
public class FirstTrySVGCreator extends Creator{
	int WidthInPixel;
	int HeightInPixel;
	StyleAttributes attributes = null;
	int PositionShift = 0;
	private int fieldFactor = 4;
	boolean GoUp = true;
	
	public FirstTrySVGCreator(int WidthInPixel, int  HeightInPixel) {
		super(WidthInPixel, HeightInPixel);
		this.WidthInPixel = WidthInPixel;
		this.HeightInPixel = HeightInPixel;
	}
	
	@Override
	public String getSVGContent (){
		int xFields = this.fieldFactor;
		int yFields = xFields;
		Point [][][] CanvasFields = this.getCanvasFields(xFields,yFields);
		this.setBaseAttributes();
		String SVGFields = ""; 
		for (int x = 0; x < xFields; x++) {
			for (int y = 0; y < xFields; y++) {
				SVGFields += this.GetOneFieldAsString(CanvasFields,new Point(x,y));
			}
		}
		return SVGFields;
	}
	
	public void setFieldFactor(int FieldFactor) {
		this.fieldFactor = FieldFactor;
	}
	
	private String GetOneFieldAsString(Point [][][] CanvasFields, Point Position) {
		Line stroke = new Line(this.attributes);
		Point startPostion = changePosition(CanvasFields[Position.x][Position.y][0]);
		stroke.setStartPoint( startPostion );
		Point endPosition = changePosition(CanvasFields[Position.x][Position.y][1]);
		stroke.setEndPoint( new Point(this.WidthInPixel/2, this.HeightInPixel/2) );
		this.PositionShiftMagic(CanvasFields[0][0][1]);
		return stroke.getAsString();
	}
	private void PositionShiftMagic (Point fieldSize) {
		
		if (this.PositionShift > fieldSize.x){
			this.GoUp = false;
		}
		if (this.PositionShift < 0){
			this.GoUp = true;
		}
		if (this.GoUp){
			this.PositionShift += Math.random()*11;			
		}else{
			this.PositionShift -= Math.random()*9;
		}
		
	}
	private Point changePosition(Point position) {
		
		position.x += this.PositionShift;
		position.y += this.PositionShift;
		return position;
	}
	
	private Point [][][] getCanvasFields (int xFields, int yFields){
		CanvasSpliter canvasSpliter = new CanvasSpliter(this.WidthInPixel, this.HeightInPixel);
		canvasSpliter.setAmountOfFields(xFields, yFields);
		return canvasSpliter.getFields();
	}
	
	private void setBaseAttributes (){
		this.attributes = new StyleAttributes();
		this.attributes.setStrokeWidth("0.5");
	}
}

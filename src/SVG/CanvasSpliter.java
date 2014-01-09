package SVG;

import java.awt.Point;

public class CanvasSpliter {
	int canvasWidth;
	int canvasHeight;
	int amountOfFieldsX = 1;
	int amountOfFieldsY = 1;
	int WidthOfField;
	int HeightOfField;
	
	public CanvasSpliter( int canvasWidth, int canvasHeight ) {
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
	}
	
	public void setAmountOfFields (int amountOfFieldsX, int amountOfFieldsY){
		this.amountOfFieldsX = amountOfFieldsX;
		this.amountOfFieldsY = amountOfFieldsY;
	}

	public Point [][][] getFields (){
		this.setAmountofFields();
		Point [][][] fields = new Point [this.amountOfFieldsX][this.amountOfFieldsY][];
		for (int x = 0; x < this.amountOfFieldsX; x++) {
			for (int y = 0; y < this.amountOfFieldsY; y++) {
				fields[x][y] = this.getField(x,y);				
			}
		}
		return fields;
	}
	
	private void setAmountofFields (){
		this.HeightOfField = this.canvasHeight /  this.amountOfFieldsY;
		this.WidthOfField = this.canvasWidth /  this.amountOfFieldsX;
	}
	
	private Point [] getField (int xPosition, int yPosition){
		Point [] Field = new Point [2]; 
		int x1 = xPosition * this.WidthOfField;
		int y1 = yPosition * this.HeightOfField;
		Field[0] = new Point(x1,y1);

		int x2 = (xPosition + 1) * this.WidthOfField;
		int y2 = (yPosition + 1) * this.HeightOfField;
		Field[1] = new Point(x2,y2);
		return Field;
	}
}

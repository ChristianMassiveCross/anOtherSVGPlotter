package FirstTry;
import java.awt.Point;

import SVG.CanvasSpliter;
import SVG.Creator;
import SVG.BaseAttributes;
import SVG.Stroke;
public class FirstTrySVGCreator extends Creator{
	int WidthInPixel;
	int HeightInPixel;

	public FirstTrySVGCreator(int WidthInPixel, int  HeightInPixel) {
		super(WidthInPixel, HeightInPixel);
		this.WidthInPixel = WidthInPixel;
		this.HeightInPixel = HeightInPixel;
	}
	@Override
	public String getSVGContent (){
		CanvasSpliter canvasSpliter = new CanvasSpliter(this.WidthInPixel, this.HeightInPixel);
		canvasSpliter.setAmountOfFields(2, 2);
		Point [][][] splitedCanvas = canvasSpliter.getFields();
		
		BaseAttributes attributes = new BaseAttributes();
		attributes.setStrokeWidth("2.0");
		Stroke stroke = new Stroke(attributes);
		
		stroke.setEndPoint( splitedCanvas[0][0][0] );
		stroke.setEndPoint( splitedCanvas[0][0][1] );

		return stroke.getAsString();
	}
}

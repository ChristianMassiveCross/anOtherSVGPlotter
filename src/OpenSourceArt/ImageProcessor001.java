package OpenSourceArt;

import image.PNG;
import image.Pixel;
import image.RGBGreyPixel;
import image.RGBPixel;

import java.awt.Point;
import java.util.Iterator;
import java.util.Vector;

import svg.element.Rect;
import svg.element.attribute.AreaAttribute;
import svg.element.attribute.PositionAttribute;
import svg.element.attribute.StyleAttribute;
import svg.element.attribute.property.Color;


public class ImageProcessor001 implements ImageProcessor {
	private int tileWidth = 100;
	private int tileHeight = 100;

	public ImageProcessor001() {
		this.setTileWidth(100);
		this.setTileHeight(this.getTileWidth());
	}

	public ImageProcessor001(int width, int height) {
		this.setTileWidth(width);
		this.setTileHeight(height);
	}

	@Override
	public Vector<String> process(PNG png) {
		Vector<String> outPutMatrix = new Vector<String>();
		for (int y = 0; y < png.getHeight(); y++) {
			int x = 0;
			for (Iterator<Pixel> pixelIterator = png.getNextLine()
					.iterator(); pixelIterator.hasNext();) {// TODO get next
															// line == get next
															// pixel
				Pixel i = pixelIterator.next();
				outPutMatrix.add(
						this.createSVGElement(new Point(x*100, y*100), this.pixelToColor(i) ) );
				x++;
			}
		}
		return outPutMatrix;
	}
	private String createSVGElement(Point pos, Color color) {
		PositionAttribute position = new PositionAttribute();
		position.setPosition(pos);
		AreaAttribute area = new AreaAttribute();
		area.setArea(this.getTileWidth(), this.getTileHeight());
		StyleAttribute style = new StyleAttribute();
		style.fill(color);
		style.stroke(color);
		Rect rect = new Rect(position, area, style);
		return rect.getAsString();
	}
	
	private Color pixelToColor (Pixel pixel) {
		Color color = new Color(
				pixel.red(),
				pixel.green(),
				pixel.blue()
		);
		return color;
	}
	/*----------------------------------------------------------------------------------*/
	private int getTileWidth() {
		return tileWidth;
	}

	private void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	private int getTileHeight() {
		return tileHeight;
	}

	private void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
}

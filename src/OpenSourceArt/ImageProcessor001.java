package OpenSourceArt;

import image.PNG;
import image.Pixel;
import image.RGBGreyPixel;

import java.awt.Point;
import java.util.Iterator;
import java.util.Vector;

import svg.element.Rect;


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
			for (Iterator<RGBGreyPixel> pixelIterator = png.getNextLine()
					.iterator(); pixelIterator.hasNext();) {// TODO get next
															// line == get next
															// pixel
				Pixel i = pixelIterator.next();
				outPutMatrix.add(
						this.createSVGElement(new Point(x, y), i.getColor() ) );
				x++;
			}
		}
		return outPutMatrix;
	}

	private String createSVGElement(Point position, svg.element.attribute.property.Color color) {
		Point tileSize = new Point(this.getTileWidth(), this.getTileHeight());
		Rect rect = new Rect(position, tileSize);
		rect.setStyle(color);
		return rect.getAsString();
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

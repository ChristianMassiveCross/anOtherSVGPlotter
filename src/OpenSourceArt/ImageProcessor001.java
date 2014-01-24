package OpenSourceArt;

import image.PNG;
import image.RGBGreyPixel;

import java.awt.Point;
import java.util.Iterator;
import java.util.Vector;

import SVG.Colors;
import SVG.Rect;

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
			for (Iterator<RGBGreyPixel> iterator = png.getNextLine().iterator(); iterator
					.hasNext();) {
				RGBGreyPixel i = iterator.next();
				outPutMatrix.add(
						this.createSVGElement(i.red(),i.green(),i.blue(),
						new Point(x, y))
				);
				x++;
			}
		}
		return outPutMatrix;
	}

	private String createSVGElement(int r, int g, int b, Point position) {
		Rect rect = new Rect(position,new Point(this.getTileWidth(),this.getTileHeight()));
		Colors colors = new Colors(r,g,b);
		rect.setStyle(colors);
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

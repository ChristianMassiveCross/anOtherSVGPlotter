package OpenSourceArt;

import java.awt.Point;
import java.util.Vector;

import image.PNG;

public class ImageProcessor001 implements ImageProcessor {
	private int tileWidth = 10;
	private int tileHeight = 10;

	public ImageProcessor001() {
		this.setTileWidth(10);
		this.setTileHeight(this.getTileWidth());
	}

	public ImageProcessor001(int width, int height) {
		this.setTileWidth(width);
		this.setTileHeight(height);
	}

	@Override
	public Vector<Point>[] process(PNG png) {
		png.getNextLine();
		return null;
	}

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

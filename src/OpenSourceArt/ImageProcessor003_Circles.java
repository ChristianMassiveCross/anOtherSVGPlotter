package OpenSourceArt;

import image.raster.ImageContainer;
import image.raster.attribute.Pixel;

import java.awt.Point;
import java.util.Vector;

import svg.element.Rect;
import svg.element.attribute.AreaAttribute;
import svg.element.attribute.PositionAttribute;
import svg.element.attribute.StyleAttribute;
import svg.element.attribute.property.Color;

public class ImageProcessor003_Circles implements ImageProcessor {
	private int tileWidth = 100;
	private int tileHeight = 100;

	public ImageProcessor003_Circles(int edgeLength) {
		this.setTileWidth(edgeLength);
		this.setTileHeight(this.getTileWidth());
	}

	public ImageProcessor003_Circles(int width, int height) {
		this.setTileWidth(width);
		this.setTileHeight(height);
	}

	@Override
	public Vector<String> process(ImageContainer imageContainer, int removeMe) {
		Pixel[][] pixelMatrix = imageContainer.getPixelMatrix();
		Point tileSize = new Point(
				this.getTileHeight(),
				this.getTileWidth()
		); 
		CircleEngine circleEngine = new CircleEngine(pixelMatrix, tileSize);
		Vector<String> outPutMatrix = new Vector<String>();
		Point matrix = new Point(pixelMatrix[0].length,pixelMatrix.length);
		outPutMatrix.add(this.getBackgound(matrix));
		for (int y = 0; y < pixelMatrix.length; y++) {
			for (int x = 0; x < pixelMatrix[y].length; x++) {
				outPutMatrix.add(circleEngine.createPixel(new Point(x,y)));
			}
		}
		return outPutMatrix;
	}
	private String getBackgound(Point matrix) {
		PositionAttribute position = new PositionAttribute();
		position.setPosition(new Point(0,0));
		AreaAttribute area = new AreaAttribute();
		area.setArea(
				this.getTileWidth()*matrix.x,
				this.getTileHeight()*matrix.y
		);
		StyleAttribute style = new StyleAttribute();
		style.fill(new Color(255,255,255));
		Rect rect = new Rect(position, area, style);
		
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

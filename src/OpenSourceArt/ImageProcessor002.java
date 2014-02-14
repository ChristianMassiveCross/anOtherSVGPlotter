package OpenSourceArt;

import image.png.PNG;
import image.raster.ImageContainer;
import image.raster.attribute.Pixel;

import java.awt.Point;
import java.util.Vector;

import svg.element.Line;
import svg.element.Path;
import svg.element.Rect;
import svg.element.attribute.AreaAttribute;
import svg.element.attribute.LineAttribute;
import svg.element.attribute.PathAttribute;
import svg.element.attribute.PositionAttribute;
import svg.element.attribute.StyleAttribute;
import svg.element.attribute.property.Color;


public class ImageProcessor002 implements ImageProcessor {
	private int tileWidth = 100;
	private int tileHeight = 100;

	public ImageProcessor002(int edgeLength) {
		this.setTileWidth(edgeLength);
		this.setTileHeight(this.getTileWidth());
	}

	public ImageProcessor002(int width, int height) {
		this.setTileWidth(width);
		this.setTileHeight(height);
	}

	@Override
	public Vector<String> process(ImageContainer imageContainer, int tileSize) {
		Pixel [][] pixelMatrix = imageContainer.getPixelMatrix();
		Vector<String> outPutMatrix = new Vector<String>();
		for (int y = 0; y < pixelMatrix.length; y++) {
			for (int x = 0; x < pixelMatrix[y].length; x++) {
				outPutMatrix.add( 
								this.createZickZackStroke(
										new Point(x*tileSize, y*tileSize),
										pixelMatrix[x][y]
								)
				);
			}
		}
		return outPutMatrix;
	}
	private String createZickZackStroke(Point pos,Pixel pixel){
		float hightFactor = 1.0f-pixel.red()/255.f;
		int height = this.getTileHeight();
		int width = this.getTileWidth();
		Path path = new Path();
		PathAttribute pathAttributes = new PathAttribute();
		pathAttributes.moveTo(new Point(pos.x,pos.y+(height/2)));
		pathAttributes.lineTo(new Point(pos.x+(width/5),(int)(pos.y+(height/2)*hightFactor)));
		pathAttributes.lineTo(new Point(pos.x+(width/5*4),(int)((pos.y+(height-(height/2)*hightFactor)))));
		pathAttributes.lineTo(new Point(pos.x+width,(pos.y+(height/2))));
		path.setPathAtributes(pathAttributes);
		
		StyleAttribute styleAttributes = new StyleAttribute();
		int currentRed = (int)(255*(1.0f-hightFactor));
		styleAttributes.fill(new Color());
		styleAttributes.stroke(new Color(currentRed,0,0));
		styleAttributes.strokeWidth(5.0f);
		path.setStyle(styleAttributes);
		return path.getAsString();
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

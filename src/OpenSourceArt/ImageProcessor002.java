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
		Pixel[][] pixelMatrix = imageContainer.getPixelMatrix();
		Vector<String> outPutMatrix = new Vector<String>();
		for (int y = 0; y < pixelMatrix.length; y++) {
			outPutMatrix.add(this.processLine(pixelMatrix[y],y));
		}
		return outPutMatrix;
	}

	private String processLine (Pixel[] pixelLine,int y){
		String SVGLine = "";
//		int height = this.getTileHeight();
//		int width = this.getTileWidth();
		this.getPointsOfLine(pixelLine, y);
//		for (int x = 0; x < pixelLine.length; x++) {
//			SVGLine = SVGLine.concat(
//					this.createZickZackStroke(
//							new Point(y * height, x * width),
//							pixelLine[x]
//					)
//			);
//		}
		return SVGLine;
	}
	private Vector<Point> getPointsOfLine (Pixel[] pixelLine, int y){
		Vector<Point[]> pixels = new Vector<Point[]>();
		for (int x = 0; x < pixelLine.length; x++) {
			pixels.add(this.getPointOfPixel(new Point(x,y), pixelLine[x]));
//			SVGLine = SVGLine.concat(
//					this.createZickZackStroke(
//							new Point(y * height, x * width),
//							pixelLine[x]
//					)
//			);
		}
		Vector<Point> vectorLine = new Vector<Point>();
		
		return vectorLine;
		
	}
	private Point[] getPointOfPixel (Point pos, Pixel pixel){
		float intensenty = pixel.red();
		int height = this.getTileHeight();
		int width = this.getTileWidth();
		int yMiddlePosition = pos.y + (height / 2);
		int xStartPosition = pos.x;
		int xEndPosition = pos.x + width;
		Point startPoint = new Point(xStartPosition, yMiddlePosition);
		Point endPoint = new Point( xEndPosition ,yMiddlePosition);
		
		this.doSubDivision(1,pos);
		Point[] pa = new Point[10];
		return pa;
	}
	private Point[] doSubDivision(int ZickZackAmount, Point pixelPosition){
		
		int height = this.getTileHeight();
		int width = this.getTileWidth();
		int yEndPosition = pixelPosition.y + height;
		int yStartPosition = pixelPosition.y;
		int MiddlePointAmount = ZickZackAmount*5; // (middle) upper (middle) lower (middle)
		int dividerLenght = width  / MiddlePointAmount;
		boolean isNextUpperPoint = true;
		for (int i = 1; i < MiddlePointAmount; i+=2) {
			System.out.println(pixelPosition.x*width+i*dividerLenght);
			if ( isNextUpperPoint){
				System.out.println("y: up");
				isNextUpperPoint = false;
			}else{
				System.out.println("y: down");
				isNextUpperPoint = true;
			}
				
		}
		Point[] pa = new Point[10];
		return pa;
		
	}
	
	
	private String createZickZackStroke(Point pos, Pixel pixel) {
		float hightFactor = 1.0f - pixel.red() / 255.f;
		int height = this.getTileHeight();
		int width = this.getTileWidth();
		Path path = new Path();
		PathAttribute pathAttributes = new PathAttribute();
		pathAttributes.moveTo(new Point(pos.x, pos.y + (height / 2)));
		pathAttributes.lineTo(new Point(pos.x + (width / 5),
				(int) (pos.y + (height / 2) * hightFactor)));
		pathAttributes.lineTo(new Point(pos.x + (width / 5 * 4),
				(int) ((pos.y + (height - (height / 2) * hightFactor)))));
		pathAttributes.lineTo(new Point(pos.x + width, (pos.y + (height / 2))));
		path.setPathAtributes(pathAttributes);

		StyleAttribute styleAttributes = new StyleAttribute();
		int currentRed = (int) (255 * (1.0f - hightFactor));
		styleAttributes.fill(new Color());
		styleAttributes.stroke(new Color(currentRed, 0, 0));
		styleAttributes.strokeWidth(5.0f);
		path.setStyle(styleAttributes);
		return path.getAsString();
	}

	private Color pixelToColor(Pixel pixel) {
		Color color = new Color(pixel.red(), pixel.green(), pixel.blue());
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

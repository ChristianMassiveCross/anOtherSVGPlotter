package OpenSourceArt;

import image.raster.ImageContainer;
import image.raster.RGBInterpreter;

import java.awt.image.TileObserver;
import java.io.IOException;
import java.util.Vector;

import SVG.Creator;
import SVG.Writer;

public class PixelToLine {
	private ImageContainer imageContainer;
	private Vector<String> svgElements;
	private ImageProcessor imageProcessor;
	private int tileSize = 100;

	public static void main(String[] args) {
		int TileSize = 100;
		ImageProcessor iP = new ImageProcessor003_Circles(TileSize);
		PixelToLine ptl = new PixelToLine(iP);
		ptl.setTileSize(TileSize);
		ptl.go("3to3.png");
	}


	public PixelToLine(ImageProcessor imageProcessor,int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
		this.setImageProcessor(imageProcessor);
	}

	public void go(String inputFileName) {
		this.openImage(inputFileName);
		this.process();
		this.writeSVG();
	}

	private void openImage(String fileName) {
		try {
			RGBInterpreter interpreter = new RGBInterpreter();
			ImageContainer ic = new ImageContainer(fileName, interpreter);
			setImageContainer(ic);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void process() {
		Vector<String> contend;
		contend = this.getImageProcessor().process(this.getImageContainer(),this.getTileSize());
		setSVGElments(contend);
	}


	private void writeSVG() {
		Creator svg = new Creator(this.imageContainer.getWidth()*this.getWidth(),this.imageContainer.getHeight()*this.getHeight());
		svg.setSvgElements(this.getSvgElements());
		Writer svgWriter = new Writer("CirclesFoto.svg");
		svgWriter.write(svg.getSVGAsString());
	}

	private Vector<String> getSvgElements() {
		return svgElements;
	}

	private void setSVGElments(Vector<String> svgElements) {
		this.svgElements = svgElements;
	}

	private ImageContainer getImageContainer() {
		return this.imageContainer;
	}

	private void setImageContainer(ImageContainer imageContainer) {
		this.imageContainer = imageContainer;
	}

	private ImageProcessor getImageProcessor() {
		return imageProcessor;
	}

	private void setImageProcessor(ImageProcessor imageProcessor) {
		this.imageProcessor = imageProcessor;
	}

	private int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	private int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

}

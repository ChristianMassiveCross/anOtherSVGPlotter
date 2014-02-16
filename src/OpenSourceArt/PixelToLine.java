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
		ImageProcessor iP = new ImageProcessor002(TileSize);
		PixelToLine ptl = new PixelToLine(iP);
		ptl.setTileSize(TileSize);
		ptl.go("3to3.png");
	}

	public PixelToLine(ImageProcessor imageProcessor) {
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
		setSVGElments(this.getImageProcessor().process(this.getImageContainer(),this.getTileSize()));
	}

	private void writeSVG() {
		Creator svg = new Creator(this.imageContainer.getWidth()*this.getTileSize(),this.imageContainer.getHeight()*this.getTileSize());
		svg.setSvgElements(this.getSvgElements());
		Writer svgWriter = new Writer("newOutput2.svg");
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

	private int getTileSize() {
		return tileSize;
	}

	private void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}
}

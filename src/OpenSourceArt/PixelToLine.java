package OpenSourceArt;

import image.PNG;

import java.awt.Point;
import java.io.IOException;
import java.util.Vector;

public class PixelToLine {
	private PNG png;
	private Vector<Point>[] allLinesAsPoints;
	private ImageProcessor imageProcessor;

	public PixelToLine(ImageProcessor imageProcessor) {
		this.setImageProcessor(imageProcessor);
	}

	public void go(String inputFileName) {
		this.openPNG(inputFileName);
		this.process();
		this.writeSVG();
	}

	private void openPNG(String fileName) {
		try {
			setPng(new PNG(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void process() {
		setAllLinesAsPoints(this.getImageProcessor().process(this.getPng()));
	}

	private void writeSVG() {
		this.getAllLinesAsPoints();
	}

	private Vector<Point>[] getAllLinesAsPoints() {
		return allLinesAsPoints;
	}

	private void setAllLinesAsPoints(Vector<Point>[] allLinesAsPoints) {
		this.allLinesAsPoints = allLinesAsPoints;
	}

	private PNG getPng() {
		return this.png;
	}

	private void setPng(PNG png) {
		this.png = png;
	}

	private ImageProcessor getImageProcessor() {
		return imageProcessor;
	}

	private void setImageProcessor(ImageProcessor imageProcessor) {
		this.imageProcessor = imageProcessor;
	}
}

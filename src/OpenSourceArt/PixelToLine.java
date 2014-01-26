package OpenSourceArt;

import image.PNG;

import java.io.IOException;
import java.util.Vector;

import SVG.Creator;
import SVG.Writer;

public class PixelToLine {
	private PNG png;
	private Vector<String> svgElements;
	private ImageProcessor imageProcessor;

	public static void main(String[] args) {
		ImageProcessor iP = new ImageProcessor001();
		PixelToLine ptl = new PixelToLine(iP);
		ptl.go("foto.png");
	}

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
		setSVGElments(this.getImageProcessor().process(this.getPng()));
	}

	private void writeSVG() {
		Creator svg = new Creator(this.png.getWidth()*100,this.png.getHeight()*100);
		svg.setSvgElements(this.getSvgElements());
		Writer svgWriter = new Writer("test.svg");
		svgWriter.write(svg.getSVGAsString());
	}

	private Vector<String> getSvgElements() {
		return svgElements;
	}

	private void setSVGElments(Vector<String> svgElements) {
		this.svgElements = svgElements;
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

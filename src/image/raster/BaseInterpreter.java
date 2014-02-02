package image.raster;

import image.raster.attribute.Pixel;

import java.awt.image.BufferedImage;

public class BaseInterpreter implements BinaryInterpreter {
	private Pixel[][] pixelMatrix;
	int width;
	int height;
	public void readImage(BufferedImage bufferdImage) {
		this.width = bufferdImage.getWidth();
		this.height = bufferdImage.getHeight();
		this.calculateMatrix( bufferdImage);
	}

	protected void calculateMatrix( BufferedImage bufferdImage) {
		Pixel[][] pixelMatrix = new Pixel[this.width][this.height];
		this.setPixelMatrix(pixelMatrix);
	}

	public Pixel[][] getPixelMatrix() {
		return this.pixelMatrix;
	}

	protected void setPixelMatrix(Pixel[][] pixelMatrix) {
		this.pixelMatrix = pixelMatrix;
	}
}
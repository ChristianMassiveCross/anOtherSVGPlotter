package image.raster;

import image.raster.attribute.Pixel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageContainer {
	private BufferedImage bufferdImage;
	private BinaryInterpreter binaryInterpreter;
	private Pixel[][] pixelMatrix;
	private int height;
	private int width;

	public ImageContainer(String filePath) throws IOException {
		BinaryInterpreter binaryInterpreter = new BaseInterpreter();
		this.loadImage(filePath, binaryInterpreter);
	}

	public ImageContainer(String filePath, BinaryInterpreter binaryInterpreter)
			throws IOException {
		this.loadImage(filePath, binaryInterpreter);
	}

	private void loadImage(String filePath, BinaryInterpreter binaryInterpreter)
			throws IOException {
		File FileHandler = new File(filePath);
		this.binaryInterpreter = binaryInterpreter;
		this.setBufferdImage(ImageIO.read(FileHandler));
		this.getDataFromImage();
	}

	private void getDataFromImage() {
		this.setHeight(this.getBufferdImage().getHeight());
		this.setWidth(this.getBufferdImage().getWidth());
		this.readImageToMatrix();
	}
;
	private void readImageToMatrix() {
		this.binaryInterpreter.readImage(this.getBufferdImage());
		Pixel[][] pixelMatrix = binaryInterpreter.getPixelMatrix();
		this.setPixelMatrix(pixelMatrix);
	}

	private void setBufferdImage(BufferedImage bufferdImage) {
		this.bufferdImage = bufferdImage;
	}

	private BufferedImage getBufferdImage() {
		return bufferdImage;
	}

	public int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	public Pixel[][] getPixelMatrix() {
		return pixelMatrix;
	}

	private void setPixelMatrix(Pixel[][] pixelMatrix) {
		this.pixelMatrix = pixelMatrix;
	}

}

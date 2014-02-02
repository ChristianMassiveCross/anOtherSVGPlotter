package image.raster;

import image.raster.attribute.Pixel;

import java.awt.image.BufferedImage;

public interface BinaryInterpreter {
	public void readImage(BufferedImage bufferdImage);
	public Pixel[][] getPixelMatrix();
}

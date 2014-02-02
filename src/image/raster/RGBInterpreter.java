package image.raster;

import java.awt.image.BufferedImage;

import image.raster.attribute.Pixel;
import image.raster.attribute.RGBPixel;

public class RGBInterpreter extends BaseInterpreter {
	@Override
	protected void calculateMatrix(BufferedImage bufferdImage) {
		Pixel[][] pixelMatrix = new Pixel[this.width][this.height];
		for (int y = 0; y < pixelMatrix.length; y++) {
			for (int x = 0; x < pixelMatrix[y].length; x++) {
				pixelMatrix[x][y] = new RGBPixel(bufferdImage.getRGB(x, y));
			}
		}
		this.setPixelMatrix(pixelMatrix);
	}
}

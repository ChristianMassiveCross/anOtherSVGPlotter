package image.raster;

import image.raster.attribute.Pixel;
import image.raster.attribute.RGBGreyPixel;

import java.awt.image.BufferedImage;

public class GreyInterpreter extends BaseInterpreter{
	private String SchemaName = "Average";
	
	@Override
	protected void calculateMatrix(BufferedImage bufferdImage) {
		Pixel[][] pixelMatrix = new Pixel[this.width][this.height];
		for (int y = 0; y < pixelMatrix.length; y++) {
			for (int x = 0; x < pixelMatrix[y].length; x++) {
				int IntWithAllChannels = bufferdImage.getRGB(x, y);
				RGBGreyPixel grey = new RGBGreyPixel(IntWithAllChannels); 
				grey.setGreyScaleFactorsPreset(this.getSchemaName());
				pixelMatrix[x][y] = grey;
			}
		}
		this.setPixelMatrix(pixelMatrix);
	}
	
	private String getSchemaName() {
		return SchemaName;
	}
	public void setSchemaName(String schemaName) {
		SchemaName = schemaName;
	}
}

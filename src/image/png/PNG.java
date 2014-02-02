package image.png;

import image.Pixel;
import image.RGBGreyPixel;
import image.RGBPixel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class PNG { // todo name doof
	private BufferedImage imageObject;
	private int height;
	private int width;
	private int currentLine = 0;
	private String schemaName;

	// picture opener
	public PNG(String FileName) throws IOException {
		File FileHandler = new File(FileName);
		this.setImageObject(ImageIO.read(FileHandler));
		this.setHeight(this.getImageObject().getHeight());
		this.setWidth(this.getImageObject().getWidth());
	}
	// liner
	public Vector<Pixel> getNextLine() {
		Vector<Pixel> line = new Vector<Pixel>();
		for (int x = 0; x < this.getWidth(); x++) {
			line.add(this.getPixel(x, this.getCurrentLine()));
		}
		this.setCurrentLine(this.getCurrentLine() + 1);
		return line;
	}

	public Pixel getPixel(int x, int y) {
		int AllChannels = this.getImageObject().getRGB(x, y);
		Pixel color = new RGBPixel(AllChannels);
		return color;
	}

	public Pixel getPixelInGrey(int x, int y) {
		int AllChannels = this.getImageObject().getRGB(x, y);
		RGBGreyPixel grey = new RGBGreyPixel(AllChannels);
		grey.setGreyScaleFactorsPreset(this.getSchemaName());
		return grey;
	}
	
	public int getPixelInAlfa(int x, int y) {
		return this.getPixel(x, y).alfa();
	}

	public int getPixelInRed(int x, int y) {
		return this.getPixel(x, y).red();
	}

	public int getPixelInGreen(int x, int y) {
		return this.getPixel(x, y).green();
	}

	public int getPixelInBlue(int x, int y) {
		return this.getPixel(x, y).blue();
	}

	public void setGreyScaleFactorsPreset(String SchemaName) {
		this.setSchemaName(SchemaName);
	}

	public BufferedImage getImageObject() {
		return imageObject;
	}

	public void setImageObject(BufferedImage imageObject) {
		this.imageObject = imageObject;
	}

	public int getHeight() {
		return this.height;
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

	private int getCurrentLine() {
		return currentLine;
	}

	private void setCurrentLine(int currentLine) {
		this.currentLine = currentLine;
	}

	private String getSchemaName() {
		return schemaName;
	}

	private void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

}

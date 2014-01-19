package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class PNG {
	private BufferedImage imageObject;
	private int height;
	private int width;
	private float factorRed = 1.0f / 3.0f;
	private float factorGreen = 1.0f / 3.0f;
	private float factorBlue = 1.0f / 3.0f;
	private int currentLine = 0;

	public PNG(String FileName) throws IOException {
		File FileHandler = new File(FileName);
		this.setImageObject(ImageIO.read(FileHandler));
		this.setHeight(this.getImageObject().getHeight());
		this.setWidth(this.getImageObject().getWidth());
	}

	public Vector<Color> getNextLine() {
		Vector<Color> co = new Vector<Color>();
		return co;
	}

	public Vector<Integer> getNextLineInGrey() {
		Vector<Integer> line = new Vector<Integer>();
		for (int x = 0; x < this.getWidth(); x++) {
			line.add(this.getPixelInGrey(x, this.getCurrentLine()));
		}
		this.setCurrentLine(this.getCurrentLine() + 1);
		return line;
	}

	public Color getPixel(int x, int y) {
		int AllChannels = this.getImageObject().getRGB(x, y);
		Color color = new Color(AllChannels);
		return color;
	}

	public int getPixelInAlfa(int x, int y) {
		int PixelWithallColors = this.getImageObject().getRGB(x, y);
		return this.shiftNumberInByte(PixelWithallColors, 3);
	}

	public int getPixelInRed(int x, int y) {
		int PixelWithallColors = this.getImageObject().getRGB(x, y);
		return this.shiftNumberInByte(PixelWithallColors, 2);
	}

	public int getPixelInGreen(int x, int y) {
		int PixelWithallColors = this.getImageObject().getRGB(x, y);
		return this.shiftNumberInByte(PixelWithallColors, 1);
	}

	public int getPixelInBlue(int x, int y) {
		int PixelWithallColors = this.getImageObject().getRGB(x, y);
		return this.shiftNumberInByte(PixelWithallColors, 0);
	}

	private int shiftNumberInByte(int number, int ByteToShift) {
		int bitToShift = ByteToShift * 8;
		number >>= bitToShift;
		number &= 0xff; // truncate 4 bytes
		return number;
	}

	public void setGreyScaleFactorsPreset(String SchemaName) {
		switch (SchemaName) {
		case "HumanEye":
			this.setGreyScaleFactors(0.299f, 0.587f, 0.114f);
			break;
		case "ZeroRed":
			this.setGreyScaleFactors(0.0f, 0.7365f, 0.2635f);
			break;
		case "Luminosity":
			this.setGreyScaleFactors(0.213f, 0.7061f, 0.0809f);
			break;
		}
	}

	public void setGreyScaleFactors(float factorRed, float factorGreen,
			float factorBlue) {
		this.setFactorRed(factorRed);
		this.setFactorGreen(factorGreen);
		this.setFactorBlue(factorBlue);
	}

	public int getPixelInGrey(int x, int y) {
		float red = this.getPixelInRed(x, y);
		float green = this.getPixelInGreen(x, y);
		float blue = this.getPixelInBlue(x, y);
		float factorRed = this.getFactorRed();
		float factorGreen = this.getFactorGreen();
		float factorBlue = this.getFactorBlue();

		red *= factorRed;
		blue *= factorBlue;
		green *= factorGreen;

		int grey = Math.round(red + green + blue);
		return grey;
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

	private float getFactorRed() {
		return this.factorRed;
	}

	private void setFactorRed(float factorRed) {
		this.factorRed = factorRed;
	}

	private float getFactorGreen() {
		return this.factorGreen;
	}

	private void setFactorGreen(float factorGreen) {
		this.factorGreen = factorGreen;
	}

	private float getFactorBlue() {
		return this.factorBlue;
	}

	private void setFactorBlue(float factorBlue) {
		this.factorBlue = factorBlue;
	}

	private int getCurrentLine() {
		return currentLine;
	}

	private void setCurrentLine(int currentLine) {
		this.currentLine = currentLine;
	}

}

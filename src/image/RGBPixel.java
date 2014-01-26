package image;

import SVG.Color;

public class RGBPixel implements Pixel {
	private int red;
	private int green;
	private int blue;
	private int alfa;
	private Color color;

	public RGBPixel(int AllColorChannels) {
		this.initColor(

		this.shiftNumberInByte(AllColorChannels, 2), // red
				this.shiftNumberInByte(AllColorChannels, 1), // green
				this.shiftNumberInByte(AllColorChannels, 0), // blue
				this.shiftNumberInByte(AllColorChannels, 3) // alfa

		);
	}

	public RGBPixel(int red, int green, int blue, int alfa) {
		this.initColor(red, green, blue, alfa);
	}

	public RGBPixel(int red, int green, int blue) {
		int defaultAlfaValue = 255;
		this.initColor(red, green, blue, defaultAlfaValue);
	}

	private void initColor(int red, int green, int blue, int alfa) {
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
		this.setAlfa(alfa);
		this.setColor(new Color(red,green,blue));
	}

	private int shiftNumberInByte(int number, int ByteToShift) {
		int bitToShift = ByteToShift * 8;
		number >>= bitToShift;
		number &= 0xff; // truncate 4 bytes
		return number;
	}

	/* -------------------------------------------------------------- */
	public int red() {
		return this.red;
	}

	private void setRed(int red) {
		this.red = red;
	}

	public int green() {
		return green;
	}

	private void setGreen(int green) {
		this.green = green;
	}

	public int blue() {
		return blue;
	}

	private void setBlue(int blue) {
		this.blue = blue;	
		}

	public int alfa() {
		return alfa;
	}

	public void setAlfa(int alfa) {
		this.alfa = alfa;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}

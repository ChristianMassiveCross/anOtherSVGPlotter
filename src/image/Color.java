package image;

public class Color {
	private int red;
	private int green;
	private int blue;
	private int grey;
	private int alfa;
	private float factorRed = 1.0f / 3.0f;
	private float factorGreen = 1.0f / 3.0f;
	private float factorBlue = 1.0f / 3.0f;

	public Color(int AllColorChannels) {
		this.initColor(
				
				this.shiftNumberInByte(AllColorChannels, 2), //red
				this.shiftNumberInByte(AllColorChannels, 1), //green
				this.shiftNumberInByte(AllColorChannels, 0), //blue
				this.shiftNumberInByte(AllColorChannels, 3) // alfa
				
	 );
	}

	public Color(int red, int green, int blue, int alfa) {
		this.initColor(red, green, blue, alfa);
	}

	public Color(int red, int green, int blue) {
		this.initColor(red, green, blue, 255);
	}

	private void initColor(int red, int green, int blue, int alfa) {
		this.setAlfa(alfa);
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
		this.setGrey();
	}

	public void setGreyScaleFactors(float factorRed, float factorGreen,
			float factorBlue) {
		this.setFactorRed(factorRed);
		this.setFactorGreen(factorGreen);
		this.setFactorBlue(factorBlue);
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

	private int shiftNumberInByte(int number, int ByteToShift) {
		int bitToShift = ByteToShift * 8;
		number >>= bitToShift;
		number &= 0xff; // truncate 4 bytes
		return number;
	}

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

	public int grey() {
		this.setGrey();
		return grey;
	}

	private void setGrey(int grey) {
		this.grey = grey;
	}

	private void setGrey() {
		float red = this.red();
		float green = this.green();
		float blue = this.blue();
		float factorRed = this.getFactorRed();
		float factorGreen = this.getFactorGreen();
		float factorBlue = this.getFactorBlue();

		red *= factorRed;
		blue *= factorBlue;
		green *= factorGreen;

		int grey = Math.round(red + green + blue);
		this.setGrey(grey);
	}

	public int alfa() {
		return alfa;
	}

	public void setAlfa(int alfa) {
		this.alfa = alfa;
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
}

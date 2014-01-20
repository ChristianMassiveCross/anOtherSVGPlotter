package image;

public class RGBGreyPixel extends RGBPixel {
	private float factorRed = 1.0f / 3.0f;
	private float factorGreen = 1.0f / 3.0f;
	private float factorBlue = 1.0f / 3.0f;

	public RGBGreyPixel(int AllColorChannels) {
		super(AllColorChannels);
	}

	public RGBGreyPixel(int red, int green, int blue, int alfa) {
		super(red, green, blue, alfa);
	}

	public RGBGreyPixel(int red, int green, int blue) {
		super(red, green, blue);
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

	public int grey() {
		return this.calcGrey();
	}

	private int calcGrey() {
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
		return grey;
	}

	/* -------------------------------------------------------------- */
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

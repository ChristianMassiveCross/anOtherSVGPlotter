package image;

public class Color {
	private int red;
	private int green;
	private int blue;
	private int grey;

	public Color(int AllColorChannels) {
		// TODO Auto-generated constructor stub
	}
	public Color(int red, int green, int blue) {
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
		this.setGrey();
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
		return grey;
	}
	private void setGrey(int grey) {
		this.grey = grey;
	}
	private void setGrey() {
		// TODO Auto-generated method stub
		
	}

}

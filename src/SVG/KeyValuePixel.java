package SVG;

public class KeyValuePixel extends KeyValueConcat {
	static public String unit = "px";
	public KeyValuePixel(String key, String value) {
		super(key,value.concat(unit));
	}
}

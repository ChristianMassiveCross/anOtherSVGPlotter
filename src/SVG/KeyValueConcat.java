package SVG;

public class KeyValueConcat {
	private String key;
	private String value;
	private String connector = "=";
	private String valueQuotes = "'";

	public KeyValueConcat(String key, String value) {
		this.setKey(key);
		this.setValue(value);
	}

	@Override
	public String toString() {
		String OutPut = "";

		OutPut = OutPut.concat(this.getKey());
		OutPut = OutPut.concat(this.getConnector());
		OutPut = OutPut.concat(this.getValueQuotes());
		OutPut = OutPut.concat(this.getValue());
		OutPut = OutPut.concat(this.getValueQuotes());
		OutPut = OutPut.concat(" ");

		return OutPut;
	}

	private String getKey() {
		return this.key;
	}

	private void setKey(String key) {
		this.key = key;
	}

	private String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	private String getValue() {
		return this.value;
	}

	private void setValue(String value) {
		this.value = value;
	}

	private String getValueQuotes() {
		return valueQuotes;
	}

	public void setValueQuotes(String valueQuotes) {
		this.valueQuotes = valueQuotes;
	}
}

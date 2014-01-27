package svg.elements.attributes;

public class Unit {
	private String unitAbbreviation = "px";

	private String getUnitAbbreviation() {
		return unitAbbreviation;
	}

	public void setUnitAbbreviation(String unitAbbreviation) {
		this.unitAbbreviation = unitAbbreviation;
	}
	private String concatNumberWithUnit(String number) {
		String UnitPattern = "%s%s";
		String numberWithUnit = String.format(
				UnitPattern,
				number, 
				this.getUnitAbbreviation()
				);
		return numberWithUnit;
	}
	public String getWithUnit(int number) {
		Integer intNumber = new Integer(number);
		String numberAsString = intNumber.toString();
		return this.concatNumberWithUnit(numberAsString);
	}
	
	public String getWithUnit(String numberAsString) {
		return this.concatNumberWithUnit(numberAsString);
	}
	
	public String getWithUnit(Float number) {
		String numberAsString = number.toString();
		return this.concatNumberWithUnit(numberAsString);
	}
}

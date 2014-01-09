import FirstTry.FirstTrySVGCreator;
import SVG.Writer;

public class FirstTry {
	public static void main(String[] args) {
		Writer mySVGWriter = new Writer("TestLaufWurst.svg");
		FirstTrySVGCreator first = new FirstTrySVGCreator(150,150);
		String content = first.getSVGAsString();
		mySVGWriter.write(content);
	}
} 
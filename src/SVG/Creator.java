package SVG;

import java.util.Iterator;
import java.util.Vector;

public class Creator {
	int WidthInPixel;
	int HeightInPixel;
	private Vector<String> svgElements;
	
	public Creator() {
		this.WidthInPixel = 100;
		this.HeightInPixel = 200;
	}

	public Creator(int WidthInPixel, int HeightInPixel) {
		this.WidthInPixel = WidthInPixel;
		this.HeightInPixel = HeightInPixel;
	}

	public String getSVGAsString (){
		String SVG = this.getSVGHeader();
		SVG += this.getSVGContent();
		SVG += this.getSVGFooter();
		return SVG;
	}

	private String getSVGHeader(){
		String Header = "<?xml version='1.0' encoding='UTF-8'?>";
		String NameSpace = "xmlns='http://www.w3.org/2000/svg'";
		String Xlink = "xmlns:xlink='http://www.w3.org/1999/xlink'";
		String Ev = "xmlns:ev='http://www.w3.org/2001/xml-events'";
		String Version = "version='1.1'";
		String baseProfile = "baseProfile='full'";
		String Width = "width='"+this.WidthInPixel+"px'";
		String Height = "height='"+this.HeightInPixel+"px'";
		Header += "<svg "
				   + NameSpace + " "
				   + Xlink + " "
				   + Ev + " "
				   + Version + " "
				   + baseProfile + " "
				   + Width + " "
				   + Height + " "
				   +">";
		return Header;
	}

	public String getSVGContent() {
		Vector<String> elements = this.getSvgElements();
		String concatString = "";
		for (Iterator<String> iterator = elements.iterator(); iterator.hasNext();) {
			concatString = concatString.concat((String) iterator.next());
		}
		return concatString;
	}
	
	private String getSVGFooter() {
		return "</svg>";
	}

	public Vector<String> getSvgElements() {
		return svgElements;
	}

	public void setSvgElements(Vector<String> svgElements) {
		this.svgElements = svgElements;
	}

}

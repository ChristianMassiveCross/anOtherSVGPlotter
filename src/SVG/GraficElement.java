package SVG;

import java.awt.Point;

public interface GraficElement {
	public String getAsString();
	public void setStartPoint (Point startPoint);
	public void setEndPoint (Point endPoint); 
}

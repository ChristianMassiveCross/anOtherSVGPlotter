package OpenSourceArt;

import image.PNG;

import java.awt.Point;
import java.util.Vector;

public interface ImageProcessor {
	public abstract Vector<Point>[] process(PNG png);

}
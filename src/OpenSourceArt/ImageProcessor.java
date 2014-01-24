package OpenSourceArt;

import image.PNG;

import java.util.Vector;

public interface ImageProcessor {
	public abstract Vector<String> process(PNG png);
	
}
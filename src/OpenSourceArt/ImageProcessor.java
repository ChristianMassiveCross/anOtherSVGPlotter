package OpenSourceArt;

import image.raster.ImageContainer;

import java.util.Vector;

public interface ImageProcessor {
	public abstract Vector<String> process(ImageContainer imageContainer, int tileSize);
	
}
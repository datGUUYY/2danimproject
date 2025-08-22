package Default;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageNode extends Node{
	/*
	 * stores image
	 * has a "get pixel" function. To print, just get each pixel.
	 * print to screen static method or member method to get each
	 * 	pixel and respond
	 * Has a h and w, gets x and y
	 */
	//On instantiation: read buffered image, store to list of pixels.
	protected int []pixels;
	
	//fig strangler refactoring
	protected boolean hasAlpha;
	
	public ImageNode(int x, int y, int w, int h, int []pixels, boolean hasAlpha)
	{
		super(x,y,w,h);
		this.pixels = pixels;
		this.hasAlpha = hasAlpha;
	}
	public ImageNode(int x, int y, int w, int h, int []pixels)
	{
		this(x,y,w,h,pixels,true);
	}
	
	public ImageNode(int x, int y, int w, int h, String link)
	{
		//TODO: IoC container is a MUST! This shit is already complicated
		super(x,y,w,h);
		//NOTE: below is EXPENSIVE! MAKE SURE you're not calling this too many times.
		//	maybe set initialization of these files to be handled by the IoC container
		pixels = new int[h*w*3];
		try {
			BufferedImage buff = ImageIO.read(new File(link));
			buff.getData().getPixels(0,0, w, h, pixels);
			//Check if buff has alpha channel.
			hasAlpha = buff.getColorModel().hasAlpha();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//TODO: check and throw exception if w * h != pixels.length
	}

	@Override
	public int getRelative(int x, int y) {
		//if no alpha. Otherwise, different methodology is needed.
		int r,g,b;
		if(!hasAlpha)
		{
		int baseIndex = (y * w + x) * 3; 
		try {
			r = pixels[baseIndex];
			g = pixels[baseIndex + 1];
			b = pixels[baseIndex + 2];
		} catch(ArrayIndexOutOfBoundsException E)
		{
			return 0;
		}
		return 0xff000000 | r << 16 | g << 8 | b;
		}
		int a;
		int baseIndex = (y * w + x) * 4; 
		try {
			a = pixels[baseIndex];
			r = pixels[baseIndex + 1];
			g = pixels[baseIndex + 2];
			b = pixels[baseIndex + 3];
			} catch(ArrayIndexOutOfBoundsException E)
			{
				return 0;
			}
		return a<<24 | r << 16 | g << 8 | b;
	}
}

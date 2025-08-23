package Default;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainClass {
	/*
	 * This is going to be quite the bloated class in order to keep
	 * the program light. We'll use fig strangler refactoring to 
	 * isolate the code after working through it.
	 */
	
	public static int h, w;
	
	public static void main(String []args)
	{
		h = 250;
		w = 200;
		
		ImageNode in = new ImageNode(0,0,w,h,"th.jpg");
		PanningNode pn = new PanningNode(0,0,50,250);
		DraggingNode dn = new DraggingNode(0,0,50,250);
		ImageNode alphanode = new ImageNode(0,0,50,250,"th - copy.jpg");

		AlphaLayerNode aln = new AlphaLayerNode(alphanode, pn, dn);
		
		
//		UVMapperNode uv = new UVMapperNode(0,0,w,h, pn, in);
		
		UVMapperNode uv = new UVMapperNode(0,0,w,h, aln, in);
		ParentCoordNode pcn = new ParentCoordNode(0,0, w + 10, h, uv);
		SpriteAnimNode spam = new SpriteAnimNode(pcn);
		
//		SpriteAnimNode spam = new SpriteAnimNode(aln);
		toOutput(spam);
	}

	//TODO: Isolate to-output node (add thing for "link")
	public static void toOutput(Node in)
	{
		//Writing to file
		BufferedImage out = new BufferedImage(in.w,in.h,BufferedImage.TYPE_4BYTE_ABGR);
		for(int i = 0; i < in.w; i++)
			for(int j = 0; j < in.h; j++)//TODO: ISOLATE!!! REMOVE HARDCODED H
				out.setRGB(i, j, in.getAbsolute(i, j));
		out.flush();
		try {
			ImageIO.write(out, "png", new File("output.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Next steps: Create "anim" or "Spritemaker" thing
	 * 	Handled in main for the moment. Dumps each image in a row below
	 * 	operates as event broadcaster for any listeners
	 * 	throw exception for multiple broadcasters;
	 * 		NOTE: THIS NEEDS TO BE HANDLED BY AN IOC CONTAINER
	 * Then: Create "parent coord" node with "layers"
	 * 	getRelative should return pix of children offset by pix of parent coord.
	 * 
	 */
	
	//TODO: output a node to a file. (simply get one pixel at a time.)
	//TODO: stubbed output, and dependency manager
	//TODO: isolate into separate classes for dependencies and output.
	//TODO: Implement, then isolate, spritesheet node.
	//TODO: implement, then isolate, "layers" node.
}

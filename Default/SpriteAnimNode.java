package Default;

public class SpriteAnimNode extends Node {
	protected int []pixels;
	public SpriteAnimNode(Node n, int frames)
	{
		super(n.x, n.y, n.w, n.h * frames);
		pixels = new int[w * h];
		
		//NOTE: might need to refactor. 
		//	tradeoff of simplicity and flexibility for efficiency
		for (int i = 0; i < frames; i++)
		{
			for(int loopX = 0; loopX < w; loopX++)
				for(int loopY = 0; loopY < n.h; loopY++)
					pixels[(i * n.h + loopY) * w + loopX]
//							= n.getRelative(loopX, loopY); //TODO: oh shit I hope this doesn't break anything.
							=n.getAbsolute(loopX, loopY);
//			UpdatableNode.updateAll();
			Updator.updateAll();
			//This node will have to have its children constructed before it is.
		}	
		
	}
	public SpriteAnimNode(Node n)
	{
		this(n, 10);
	}
	@Override
	public int getRelative(int x, int y) {
		return pixels[y * w + x];
	}

}

package Default;

public abstract class Node implements pixelMap{
	//TODO: interface stitching as necessary
	protected int x,y, w, h; //Accessors, no mutators
	protected Updator updator; //NOTE: this should be null by default.
	//^^ refers to origin point.
	public abstract int getRelative(int x, int y);
	public int getAbsolute(int x, int y)
	{
		if(x < this.x || y < this.y
				|| x >= this.x + this.w
				|| y >= this.y + this.h)
			{return 0;}
		return getRelative(x - this.x, y - this.y);
	}
	
	public Node(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
}

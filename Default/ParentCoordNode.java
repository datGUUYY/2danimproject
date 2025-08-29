package Default;

public class ParentCoordNode extends Node{
	protected Node child;
	public ParentCoordNode(int x, int y, int w, int h, Node child)
	{
		super(x,y,w,h);
		this.child = child;
		updator = new Updator()
				{
					@Override
					protected void update() {
						child.x+= 5;
					}
				};
	}
	
	@Override
	public int getRelative(int x, int y) {
		if(x < child.x || y < child.y 
				|| x > child.x + child.w 
				|| y > child.y + child.h)
			return 0;
		return child.getAbsolute(x,y);
	}


}

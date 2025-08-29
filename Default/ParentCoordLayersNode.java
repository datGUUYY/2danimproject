package Default;

import java.util.List;

public abstract class ParentCoordLayersNode extends Node {

	protected List<Node> children;
	public ParentCoordLayersNode(int x, int y, int w, int h, List<Node> children)
	{
		super(x,y,w,h);
		this.children = children;
	}

	@Override
	public int getRelative(int x, int y) {
		// TODO: return pixels of children in class.
		/*
		 * Ahhh shit now we're going to have to talk about opacity.
		 */
		return 0;
	}
	//TODO: isolate class
}

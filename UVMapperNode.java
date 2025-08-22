package Default;

public class UVMapperNode extends Node{
	protected Node uvNode;
	protected Node sourceNode;
	public UVMapperNode(int x, int y, int w, int h, Node uv, Node source) {
		super(x, y, w, h);
		this.sourceNode = source;
		this.uvNode = uv;
	}
	public UVMapperNode(int x, int y, int w, int h, Node source)
	{
		this(x,y,w,h, 
		new PanningNode(x,y,w,h), source);
	}
	@Override
	public int getRelative(int x, int y) {
		int lookup = uvNode.getAbsolute(x, y);
		int u = lookup >> 16;
		int v = lookup & 0xffff;
//		if(sourceNode.w <= x || sourceNode.h <= y) return 0;
		return sourceNode.getAbsolute(u, v);
	}
}

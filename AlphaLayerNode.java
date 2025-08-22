package Default;

public class AlphaLayerNode  extends Node{
	protected Node alpha, base, layer;
	
	/*
	 * A node for the alpha layer
	 * A node for the base
	 * A node for the upper layer.
	 * 
	 * get relative returns, for each in RGB values:
	 * Layer * alpha + base * (1 - alpha)
	 */
	
	public AlphaLayerNode(Node alpha, Node base, Node layer) {
		super(alpha.x, alpha.y, alpha.w, alpha.h);
		//TODO: check to see if alpha, base, and layer have the same 
		//	dimensions, throw an error if not.
		this.alpha = alpha;
		this.base = base;
		this.layer = layer;
	}
	
	@Override
	public int getRelative(int x, int y) {
		
		double aVal = (double)(alpha.getRelative(x,y) >> 16) / 256;
		int baseVal = base.getRelative(x, y);
		int layerVal = layer.getRelative(x, y);
		
		//TODO: RGB VS UV?
//		double baseR = baseVal >> 16;	double baseG = (baseVal >> 8) % 256;
//		double baseB = baseVal % 256; double layR = layerVal >> 16;
//		double layG = (layerVal >> 8) % 256; double layB = layerVal % 256; 
//		int r = (int) (layR * aVal + baseR * (1 - aVal));
//		int g = (int) (layG * aVal + baseG * (1 - aVal));
//		int b = (int) (layB * aVal + baseB * (1 - aVal));
//		return 0xff000000| r << 16 | g << 8 | b;
		
		//Base is panning;
		double baseU = baseVal >> 16; double baseV = baseVal & 0xffff;
		double layU = layerVal >> 16; double layV = layerVal & 0xffff;
		int u = (int) (layU * aVal + baseU * (1 - aVal));
		int v = (int) (layV * aVal + baseV * (1 - aVal));
		return u<<16 | v;
		
//		return (int) (layerVal * aVal + baseVal * (1 - aVal));
	}
}

package Default;

public class SpringNode extends Node {
    //TODO: add parent class to handle redundant code between this and AlphaLayerNode.
    //  A good name would be "OverlayNode"

    private Node alpha;
    private Node base;
    private Node layer;

    public SpringNode(Node alpha, Node base, Node layer) {
        super(alpha.x, alpha.y, alpha.w, alpha.h);
		//TODO: check to see if alpha, base, and layer have the same 
		//	dimensions, throw an error if not.
		this.alpha = alpha;
		this.base = base;
		this.layer = layer;
        updator = new Updator() {
            @Override
            public void update() {
                throw new UnsupportedOperationException("Unimplemented method 'update'");
            }
        };
    }

    @Override
    public int getRelative(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRelative'");
    }
    
}

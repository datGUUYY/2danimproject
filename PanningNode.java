package Default;

public class PanningNode extends Node{
	
	int v_x, v_y;
	public PanningNode(int x, int y, int w, int h) {
		super(x, y, w, h);
		v_x = 5; v_y = 0;
		PanningNode thing = this;
		updator = new Updator()
				{

					@Override
					protected void update() {
						thing.x += v_x;
						thing.y += v_y;
					}
			
				};
	}
	
	@Override
	public int getRelative(int x, int y) {
		//The node is simply "panning", so relative should == absolute
		return (this.x + x) << 16 | (this.y + y);
	}
}

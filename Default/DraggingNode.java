package Default;

public class DraggingNode extends Node {
	int v_x, v_y;
	
	public DraggingNode(int x, int y, int w, int h) {
		super(x, y, w, h);
		v_x = 5; v_y = 0; //TODO: IoC Container?
		DraggingNode thing = this;
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
		//This should return a UV coord that simply drags across the screen.
		return (x) << 16 | (y);
	}
}

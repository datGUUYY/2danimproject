package Default;

public class SpringNode extends Node{

	public SpringNode(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		
		//updator = new updator() {}...
		/*	remember, f = kx^2 = ma; k/m = c; can adjust
		 * for now, round a down. On update, change velocity,
		 * then change position. 
		 * 
		 * So:
		 * updator contains a "strength" value and a "v" for each pixel
		 * springnode contains two child nodes, one being "stretched"
		 * away from the other, its "natural" position.
		 * 
		 * updator.update
		 * for each pixel:
		 * 		for x,y: //not literal
		 * 			a = (sum of squares of diff btwn uv pixels)
		 * 			a *= strength
		 * 			v += a
		 * 			pixel += v
		 * 			pixel = pixel % [max pixel size?] //figure out soonish
		 */
	}

	@Override
	public int getRelative(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

}

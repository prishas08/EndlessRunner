import java.util.ArrayList;

public class SpaceShip extends ImageGamePiece{
	
	private int timer;
	
	SpaceShip(int x, int y, int h, int w, String s)
	{
		super(x, y, h, w, s);
		timer = 30;
	}
	
	public void keepTime()
	{
		timer++;
	}
	
	public void powerJump(ArrayList<SpaceJunk> blocks)
	{

		if (timer >= 30)
		{
			int x = (int)StdDraw.mouseX();
			int y = (int)StdDraw.mouseY();
			super.setX(x);
			super.setY(y);
			for(SpaceJunk s : blocks)
			{
				s.destroy(x, y);
			}
			timer = 0;
		}
		
	}

}

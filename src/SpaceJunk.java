
public class SpaceJunk extends ImageGamePiece{
	
	private boolean isDestroyed;
	
	SpaceJunk(int x, int y, int h, int w, String s)
	{
		super(x, y, h, w, s);
		isDestroyed = false;
	}

	public boolean getIsDestroyed()
	{
		return isDestroyed;
	}
	
	public void drawPiece()
	{
		if (isDestroyed == false)
		{
			super.drawPiece();
		}
		
		if(super.returnY() < 0)
		{
			isDestroyed = false;
		}
	}
	
	public void destroy (int x, int y)
	{
		if (x < super.getRightBound() && x>super.getLeftBound() && y < super.getUpperBound() && y > super.getLowerBound())
		{
			isDestroyed = true;
		}
	}
}

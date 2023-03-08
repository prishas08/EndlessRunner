public class GamePiece {
	
	private int centerX;
	private int centerY;
	private int height;
	private int width;
	
	private int[] color;
	
	public GamePiece(int x, int y, int h, int w, int[] arr)
	{
		centerX = x;
		centerY = y;
		height = h;
		width = w;
		color = arr;
	}
	
	public int returnX()
	{
		return centerX;
	}

	public int returnY()
	{
		return centerY;
	}
	
	public void moveY(int y)
	{
		centerY = centerY + y;
	}
	
	public void moveX(int x)
	{
		centerX = centerX + x;
	}
	
	public void setY(int y)
	{
		centerY = y;
	}
	
	public void setX(int x)
	{
		centerX = x;
	}
	
	public void drawPiece()
	{
		StdDraw.setPenColor(color[0], color[1], color[2]);
		StdDraw.filledRectangle(centerX, centerY, width, height);
	
	}
	
	public int getUpperBound()
	{
		return centerY + height;
	}
	
	public int getLowerBound()
	{
		return centerY - height;
	}
	
	public int getRightBound()
	{
		return centerX + width;
	}
	
	public int getLeftBound()
	{
		return centerX - width;
	}
	
}

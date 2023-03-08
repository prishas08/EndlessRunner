public class ImageGamePiece extends GamePiece{
	
	
	private String picture;
	private double scaledHeight;
	private double scaledWidth;
	//private int[] array;
	private static int[] array = new int[]{0,0,0};
	
	public ImageGamePiece(int x, int y, int h, int w, String s)
	{
		super(x,y,h,w,array);
		scaledHeight = h*2;
		scaledWidth = w*2;
		picture = s;
	}
	public void drawPiece()
	{
		StdDraw.picture(super.returnX(), super.returnY(), picture, scaledWidth, scaledHeight);
	}

}

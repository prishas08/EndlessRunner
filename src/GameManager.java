import java.util.ArrayList;
import java.util.Random;

public class GameManager {

	private SpaceShip hero;
	private boolean runGame;
	private ArrayList<SpaceJunk> blocks;
	Random rand = new Random();
	int[] arr = {0, 0, 0};
	
	GameManager()
	{
		hero = new SpaceShip(250, 250, 15, 15, "Ship1.gif");
		blocks = new ArrayList<SpaceJunk>();
		int y = 400;
		int x = 0; 
		int[] col = {120, 0, 0};
		for(int i = 2; i >= 0; i--)
		{
			SpaceJunk Object1 = new SpaceJunk(25+x, y, 15, 200, "SpaceJunk.gif");
			blocks.add(Object1);
			SpaceJunk Object2 = new SpaceJunk(475+x, y, 15, 200, "SpaceJunk.gif");
			blocks.add(Object2);
			y = y + 200;
			x = (int)(Math.random()*(300)) - 150;

		}
		runGame = true;
		StdDraw.setCanvasSize(500,500);
		StdDraw.setXscale(0,500);
		StdDraw.setYscale(0,500);
	}
	
	public void run()
	{
		while(runGame == true)
		{
			
			StdDraw.clear();
			hero.keepTime();
			if(StdDraw.isMousePressed())
			{
				hero.powerJump(blocks);
				StdDraw.clear();
			}
			if(StdDraw.isKeyPressed(38))
			{
				hero.moveY(10);
			}
			else if(StdDraw.isKeyPressed(40))
			{
				hero.moveY(-10);
			}
			else if(StdDraw.isKeyPressed(37))
			{
				hero.moveX(-10);
			}
			else if(StdDraw.isKeyPressed(39))
			{
				hero.moveX(10);
			}
			//9a - you can move diagonly if you press a x and w axis key at the same time, if you used an else if statement, the 2nd key that you pressed would not matter and you could no longer move diagonally
			drawGamePieces();
			collision();
			//hero.moveY(5);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void drawGamePieces()
	{
		hero.drawPiece();
		for (GamePiece x : blocks)
		{
			x.drawPiece();
			x.moveY(-8);
		}
		for(int i = 0; i < blocks.size()-1; i++)
		{
			if(blocks.get(i).returnY() < 0)
			{
				int x = (int)(Math.random()*(300)) - 150;
				int y = (int)(Math.random()*(200)) + 500;
				blocks.get(i).setY(y);
				blocks.get(i+1).setY(y);
				blocks.get(i).moveX(x);
				blocks.get(i+1).moveX(x);
			}
		}
		
	}
	
	public void collision()
	{
		for (SpaceJunk x : blocks)
		{
			if(hero.getLowerBound()<x.getUpperBound() && hero.getUpperBound()>x.getLowerBound() && hero.getLeftBound()<x.getRightBound() && hero.getRightBound()>x.getLeftBound() && x.getIsDestroyed()==false)
			{
				runGame = false;
			}
			if(x.getIsDestroyed()==true)
			{
				runGame = true;
			}
		}
	}
	
}

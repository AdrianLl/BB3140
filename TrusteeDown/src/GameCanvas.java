import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameCanvas extends JPanel implements ActionListener{
	
	//Loads the images in the background, delete later
	//Image bg = Toolkit.getDefaultToolkit().getImage("/Users/Steven/Desktop/sketch2.jpg");
	Image Running_right = Toolkit.getDefaultToolkit().getImage("/Users/Steven/Desktop/stickfigure1.gif");
	Image Running_left = Toolkit.getDefaultToolkit().getImage("/Users/Steven/Desktop/Left.gif");
	Image [] Trustee_Target = new Image[2];


	private BufferedImage Background = null;

	
	
	//Testing (x,y)
	Vector2D test = new Vector2D (700,550);
	//Trying out path size for the trustee's path
	Vector2D World_x = new Vector2D(950,600);
	
	
	int x_pos = 700, y_pos = 470;
	int x_vel = 2, y_vel= 2;
	//GameObject x, y;
	
	static final int FRAME_RATE = 30; // animation proceeds at 30 frames per second
		Timer t;	// animation timer
		//Will delete later, just to help imagine the bounds of the objects
		GameObject scoreboard_line;
		GameObject grassbound1;
		GameObject trusteebound1;
		GameObject grassbound2;
		GameObject trusteebound2;
		GameObject grass_bound3;
		GameObject Trustee_2;
		

		public GameCanvas() 
		{

			setBackground(Color.BLACK);
	        t = new Timer(1000/FRAME_RATE, this);
	        
	        Trustee_Target[0] = Running_right;
	        Trustee_Target[1] = Running_left;
	        //Grass 1024 x 66
	        //Path 1024 x 66
	        //Person 40 x 60
	        
	        //scoreboard line place holder for bounds 
	        //bottom line595 X 1024 / top line 768 x 1024
	        scoreboard_line = new GameObject(0,595, 1, 1024, 0, 0);
	        //Green grassbound area somple image is on this line
	        //bottom line 595 x 1024 / top line  530 x 1024
	        grassbound1 = new GameObject(0, 530, 1 ,1024, 0, 0);
			//Green end of grassbound line
	        //Beginning Path bottom for bound
	        //bottom line 530 x 1024 / top line  396 x 1024
	        trusteebound1 = new GameObject(0,396,1,1024,0,0);
			//Path for Trustee
	        //bottom line 396 x 1024/ top line 465 x 1024
	        grassbound2 = new GameObject(0,465, 2, 1024, 0, 0);
			//Area of the grass bound
			trusteebound2 = new GameObject(0, 330, 1,1024,0, 0);
			//grass_bound3 
			grass_bound3 = new GameObject(0, 265, 1,1024,0, 0);
			//truste_2 line
			Trustee_2 = new GameObject(0, 200, 1, 1024 ,0, 0);
		}
		
		/*
		 * Color is initialized before the wall is.
		 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
		 */
		public void paintComponent(Graphics g) 
		{

			super.paintComponent(g);
			g.drawImage(Background, 0, 0, 1024, 768, null);
			System.out.println(" canvas test.x" + test.xpos);
			//							x-axis	y-axis
			//g.drawImage(Running_right, test.getXpos(), test.getYpos(), 40, 60, null);
			
			g.drawImage(Running_right, x_pos, y_pos, 40, 60, null);
			
			//Testing movement will be editing GameObject class
			if(x_pos >= 970 || x_pos <= 10){
				if(x_pos == 970){
					x_pos = 970;
					g.drawImage(Running_left, x_pos, y_pos, 30, 30, null);
					x_vel = -x_vel;
				
				}
			}
			
			x_pos += x_vel;
			
			//Draws the first grass boundary and colors it green.
			g.setColor(Color.GREEN);
			g.fillRect(grassbound1.topLeft.x, grassbound1.topLeft.y, grassbound1.getWidth(), grassbound1.getHeight());
			
			//Draws the path of the trustee and colors it orange.
			g.setColor(Color.ORANGE);
			g.fillRect(trusteebound1.topLeft.x, trusteebound1.topLeft.y, trusteebound1.getWidth(), trusteebound1.getHeight());
			
			//Draws the second grass boundary and colors it green. 
			g.setColor(Color.GREEN);
			g.fillRect(grassbound2.topLeft.x, grassbound2.topLeft.y, grassbound2.getWidth(), grassbound2.getHeight());
			
			//Draws the boundary for the second trustee path and color it orange.
			g.setColor(Color.ORANGE);
			g.fillRect(trusteebound2.topLeft.x, trusteebound2.topLeft.y, trusteebound2.getWidth(), trusteebound2.getHeight());
			
			//Draws the boundary for the scoreboard and colors it blue. 
			g.setColor(Color.BLUE);
			g.fillRect(scoreboard_line.topLeft.x, scoreboard_line.topLeft.y, scoreboard_line.getWidth(), scoreboard_line.getHeight());
			
			//Draws the third grass boundary and colors it green.
			g.setColor(Color.GREEN);
			g.fillRect(grass_bound3.topLeft.x, grass_bound3.topLeft.y, grass_bound3.getWidth(), grass_bound3.getHeight());
			
			//Draws the second trustee boundary and colors it yellow. 
			g.setColor(Color.YELLOW);
			g.fillRect(Trustee_2.topLeft.x, Trustee_2.topLeft.y, Trustee_2.getWidth(), Trustee_2.getHeight());
			
			
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			// if this is an event from the Timer, call the method that advances the animation
			if (e.getSource() == t) {
				tick();
			}
		}
		
		private void tick() 
		{
			if(x_pos >= 970 || x_pos <= 10){
				x_vel = -x_vel;
			}

			//x.setX(getXpos()) = x.getXpos() + x_vel;
			repaint();
		}
		
		//Starts the game paint method
		public void go() 
		{
			//Loads the Background image 
			try{
				Background = ImageIO.read(new File("/Users/Steven/Documents/workspace/Game test/Images/bg.png"));
				
			} catch (IOException e){
				System.out.println("Error");
			}
			t.start();
		}

}

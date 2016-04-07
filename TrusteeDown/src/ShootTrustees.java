import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ShootTrustees {

	
	public static void main(String[] args) throws IOException {
		 JFrame frame = new JFrame("Let's Play...Shoot the Trustee");
	
	        frame.setLayout(new BorderLayout());
	        GameCanvas gameCanvas = new GameCanvas();
	        
	    	BufferedImage Background = null;
	    	BufferedImage Running_left = null;
	    	
	        frame.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR ));
	        /** using a predefined cursor for now, will switch to 
	         * a graphic later using appropriate function.RV
	         * */

	        frame.add(gameCanvas, BorderLayout.CENTER);
	        frame.setSize(1024,768);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	        // the game starts when the gamepanel animation begins
	        
	        gameCanvas.go();

	}

}

import java.awt.Point;
/*Base shape stand-in for canon
 * need to set angle to follow cursor
 *  should we use affinetransform or Graphics2D.rotate ??????????????????
 * 
 * 
 * */
public class Canon extends GameObject{

	public Canon(Point topLeft, Point bottomRight, int xSpeed, int ySpeed) {
		super(topLeft, bottomRight, xSpeed, ySpeed);
	
		
	}

	public Canon(int initX, int initY, int height, int width, int xSpeed, int ySpeed) {
		this(new Point(initX, initY), new Point(initX + width, initY + height), xSpeed, ySpeed);
	}
	
}

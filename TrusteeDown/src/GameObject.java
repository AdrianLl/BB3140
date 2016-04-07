import java.awt.Point;

public class GameObject {
	protected Point topLeft; // initial coordinates of top left corner of object
	protected Point bottomRight ; // initial coordinates of bottom left corner of
									// object
	protected int xSpeed;
	protected int ySpeed;
	
	public static boolean collide(GameObject object1, GameObject object2) {
		boolean collision = false;
		if(object1.bottomRight.x > object2.bottomRight.x && object1.bottomRight.x < object2.bottomRight.x + object2.getWidth()){
			if(object1.topLeft.y > object2.topLeft.y && object1.topLeft.y < object2.topLeft.y + object2.getHeight()){
				collision = true;
			}
		}
		return collision;	
	}
	
	public GameObject(Point topLeft, Point bottomRight, int xSpeed, int ySpeed) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public GameObject(int initX, int initY, int height, int width, int xSpeed, int ySpeed) {
		this(new Point(initX, initY), new Point(initX + width, initY + height), xSpeed, ySpeed);
	}
	
	public GameObject(int height, int width) {
		this(0, 0, height, width, 5, 0);
	}
	
	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public void accelX(int x) {
		xSpeed += x;
	}
	
	public void accelY(int y) {
		ySpeed += y;
	}
	
	public Point getTopLeft() {
		return topLeft;
	}
	
	public Point getBottomRight() {
		return bottomRight;
	}

	public int getHeight() {
		return bottomRight.y - topLeft.y;
	}
	
	public int getWidth() {
		return bottomRight.x - topLeft.x;
	}
	
	public void step() {
		topLeft.x += xSpeed;
		bottomRight.x += xSpeed;

		topLeft.y += ySpeed;
		bottomRight.y += ySpeed;
	}
	
	
}

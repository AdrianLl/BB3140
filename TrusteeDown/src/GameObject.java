import java.awt.Point;

public class GameObject {
	protected Point topLeft; // initial coordinates of top left corner of object
	protected Point bottomRight ; // initial coordinates of bottom left corner of
									// object
	protected int xSpeed;
	protected int ySpeed;
	
	//Attempt to create a collision between beanbag and trustee when they make contact.
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
	
	//Constructor for the initial position, dimensions and speed of the beanbags or any object in the game. 
	public GameObject(int initX, int initY, int height, int width, int xSpeed, int ySpeed) {
		this(new Point(initX, initY), new Point(initX + width, initY + height), xSpeed, ySpeed);
	}
	
	//Constructor for initial dimensions of the object.
	public GameObject(int height, int width) {
		this(0, 0, height, width, 5, 0);
	}
	
	//Speed of the beanbag in x direction.
	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	//Speed of beanbag in y direction.
	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	//The amount that the speed in the x-direction is changed by.
	public void accelX(int x) {
		xSpeed += x;
	}
	
	//The amount that the speed in the y-direction is changed by.
	public void accelY(int y) {
		ySpeed += y;
	}
	
	//Top left corner of the boundary of the object.
	public Point getTopLeft() {
		return topLeft;
	}
	
	//Bottom right corner of the boundary of the object. 
	public Point getBottomRight() {
		return bottomRight;
	}
	
	//Height of the object is obtained by subtracting top left corner's y-coordinate from bottom right's y-coordinate.
	public int getHeight() {
		return bottomRight.y - topLeft.y;
	}
	
	//Width of the object is obtained by subtracting top left corner's y-coordinate from bottom right's y-coordinate.
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

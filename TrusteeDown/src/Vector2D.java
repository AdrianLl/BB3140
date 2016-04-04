
public class Vector2D {
	
	public int xpos;
	public int ypos;
	
	public static int World_xpos;
	public static int World_ypos;
	
	//Default Constructor
	public Vector2D(){
		this.xpos = 0;
		this.ypos = 0;
	}
	//Constructor to set the cords of the trustees
	public Vector2D(int Xpos, int Ypos){
		this.xpos = Xpos;
		this.ypos = Ypos;
	}
	//Set the path bounds for the trustees
	public static void setWorld(int World_x, int World_y){
		World_xpos = World_x;
		World_ypos = World_y;
	}
	
	public int setX(int x){
		 return xpos = x;
	
	}
	//Get the location of the x for trustees
	public int getXpos(){
		return xpos;
	}
	
	//Get the location of the y for trustees
	public int getYpos(){
		return ypos;
	}
	
	public void normalize(){
		double length = Math.sqrt(xpos * xpos + ypos * ypos);
		if(length != 0){
			double s = 1 / length;
			xpos *= s;
			ypos *= s;
			
		}
	}
	//Checks it the vectors are equal
	public boolean equal(Vector2D vec){
		return(this.xpos == vec.xpos && this.ypos == vec.ypos);
	}

	public Vector2D add(Vector2D vec){
		xpos += vec.xpos;
		ypos += vec.ypos;
		
		return new Vector2D(xpos,ypos);
	}

}

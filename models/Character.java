package models;

public abstract class Character extends Unit {
	
	private boolean alive;
	
	private int[] pos = new int[2];
	private boolean onBoard;

	public Character(int x, int y) {
		super(x, y);
		this.alive = true;
		// TODO Auto-generated constructor stub
	}
	
	public void setPos(int x, int y)
    {
    	pos[0]=x;
    	pos[1]=y;
    }
    
    public abstract void moveable();
    
    public abstract boolean move(int x, int y);
    
    public abstract boolean attack();
    
    public abstract boolean useAbility();
    
    @Override
    public String toString(){
       return this.getClass().getSimpleName();
    }
    
    public boolean isAlive() {
        return this.alive;
    }

    public void setStatus(boolean alive) {
        this.alive = alive;
    }
    public int[] getPos(){
    	return pos ;
    }
    public int getX(){
    	return pos[0];
    }
    public int getY(){
    	return pos[1];
    }

}

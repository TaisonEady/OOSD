package models;

public abstract class Actor extends Unit {
	
	private boolean alive;
	
	private int[] pos = new int[2];
	private boolean onBoard;

	public Actor(int x, int y) {
		super(x, y);
		this.alive = true;
		// TODO Auto-generated constructor stub
	}
	
	
    
    public abstract boolean moveable(int x, int y);
    
//    public abstract boolean move(int x, int y);
    
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
    


}

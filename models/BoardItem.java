package models;

public abstract class BoardItem extends Unit{
	
	public BoardItem(int x, int y) {
		super(x, y);
	}
        public boolean moveable(int x,int y)
        {
            return false;
        }
        public boolean isAlive() {
            return true;
        }
        public void setAlive(boolean alive)
        {
        	
        }
}

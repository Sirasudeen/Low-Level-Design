package BrickBreaker;

public class Brick {
    private int strength;

    public Brick(int strength)
    {
        this.strength = strength;
    }

    public int getStrength()
    {
        return strength;
    }
    
    public void hit(){if(this.strength>0) this.strength--;}

    public boolean isBroken(){return this.strength==0;}
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class PaddleZero extends Actor
{ 
    private int speed; 

    public void act() 
    {
        int y=getY();
        if(Greenfoot.isKeyDown("right"))
        move(1);
        if(Greenfoot.isKeyDown("left"))
        move(-1);
        if(Greenfoot.isKeyDown("z"))
        turn(-1);
        if(Greenfoot.isKeyDown("x"))
        turn(1);
         setLocation(getX(),y);
    }
}


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Loose extends Actor
{
    GifImage Loose = new GifImage("loose2.gif");
    public void act()
    {
        setImage(Loose.getCurrentImage());
        getImage().scale(500,250);
    }
}

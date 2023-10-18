import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class backLoose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class backLoose extends Actor
{
    GifImage backLoose = new GifImage("loose.gif");
    public void act()
    {
        setImage(backLoose.getCurrentImage());
        getImage().scale(500,700);
    }
}

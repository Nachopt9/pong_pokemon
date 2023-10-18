import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World
{

    Loose loose = new Loose();
    backLoose bl = new backLoose();
    GreenfootImage img = new GreenfootImage(250,250);
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        super(500, 700, 1);
        img.setColor(Color.RED);
        img.drawString("YOU LOOSE",100,150);
        getBackground().drawImage(img, 150, 150);
        addObject(bl,250,350);
        addObject(loose, 250, 610);
    }
}

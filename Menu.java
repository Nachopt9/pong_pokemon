import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{
    Arrow arrow= new Arrow();
    private int option=0; //0 = PLAY / 1 = EXIT

    public Menu()
    {    
        super(500, 700, 1);
        prepareWorld();
    }
    
    private void prepareWorld()
    {
        addObject(new Play(),250, 375);
        addObject(new Exit(), 250, 555);
        addObject(arrow, 95,380);
        addObject(new Label(), 250, 150);
    }  
        
    public void act()
    {

        if (Greenfoot.isKeyDown("UP") && option!=0) {option++;}
        if (Greenfoot.isKeyDown("DOWN") && option!=1) {option--;}
        
        if (option>=2) option=0;
        if (option<0) option=1;
        
        arrow.setLocation(95,380 + (option*175));

        if (Greenfoot.isKeyDown("SPACE") || (Greenfoot.isKeyDown("ENTER")))
        {
            switch(option)
            {
                case 0: //PLAY
                    Greenfoot.setWorld(new IntroWorld());
                    break;
                case 1: //EXIT
                    Greenfoot.stop();
                    break;
            }
        }
    }
}

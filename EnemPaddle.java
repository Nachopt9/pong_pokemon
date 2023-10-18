import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class EnemPaddle extends Actor
{   
 public int speed=1;
 public boolean isInContactWithBallZero = false;
 public int getSpeed= speed+1;
     public void act()
     {
       edge();
       checkIfIsInContactWithBallZero();
       upSpeed();
     }
 
     public void upSpeed()
      {
      
        if(IntroWorld.Points.getValue() == 1)
        {
            speed = getSpeed;
        }
        if(IntroWorld.Points.getValue() == 2)
        {
            speed = getSpeed +1;
        }
        if(IntroWorld.Points.getValue() == 3)
        {
            speed = getSpeed +1;
        }
    
     }
    
    public void edge()
    {
      if(atWorldEdge()==false)
      {
        move(speed);
      }
      else
      {
        setLocation(25,Greenfoot.getRandomNumber(250)+1);
      }
    }
 
    public void checkIfIsInContactWithBallZero()
    {
     Actor ballZero = getOneIntersectingObject(BallZero.class);
     
     if(ballZero != null)
     {
        isInContactWithBallZero = true;
     }
    }
 
    public boolean atWorldEdge()
    {
        if(getX() < 10 || getX() > 490)
            return true;
        
            if(getY() < 10 || getY() >= getWorld().getHeight() - 10)
            return true;
        else
            return false;
    }
}




import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BallZero extends Actor
{
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 5;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100;
    
    public int speed=1;
    public int point = 1;
    public int getSpeed = speed;
    
    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    private boolean hasTouchedTheEnemyCeiling;
    private boolean hasTouchedMyFloor;
    private int delay;
    
    private boolean directionUp = false;
    public boolean shouldTraspassEnemPaddle;
    
    private Loose loose = new Loose();
    
    /**
     * Contructs the ball and sets it in motion!
     */
    public BallZero()
    {
        init();
    }
    
    private boolean checkForMyFloor(){
        hasTouchedMyFloor = false;
        if(this.getY() == 680){
        IntroWorld.Life.add(-1);
        hasTouchedMyFloor = true;
        } 
        if(IntroWorld.Life.getValue() == 0){
            Greenfoot.setWorld(new GameOver());
        }
        return hasTouchedMyFloor;
    };
    
        /**
     * Initialize the ball settings.
     */
    private void init()
    {
        delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        shouldTraspassEnemPaddle = false;
        setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+STARTING_ANGLE_WIDTH/2);

    }

    /**
     * Creates and sets an image of a black ball to this actor.
     */
    private void createImage()
    {
        GreenfootImage ballImage = new GreenfootImage(BALL_SIZE,BALL_SIZE);
        ballImage.fillOval(0, 0, BALL_SIZE, BALL_SIZE);
        setImage(ballImage);
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkBounceOffPaddle();
        if (delay > 0)
        {
            delay--;
        }
        else
        {
            move(speed);
            checkBounceOffWalls();
            checkBounceOffCeiling();
            checkRestart();
            checkForMyFloor();
        }
    }    
    
    /**
     * Returns true if the ball is touching one of the side walls.
     */
    private boolean isTouchingSides()
    {
        return (getX() <= BALL_SIZE/2 || getX() >= getWorld().getWidth() - BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the ceiling.
     */
    private boolean isTouchingCeiling()
    {
        
        return (getY() <= BALL_SIZE/2);
    }
   
    public void upSpeedBall()
      {
        if(IntroWorld.Points.getValue() == 1)
        {
            speed = getSpeed;
        }
        if(IntroWorld.Points.getValue() == 2)
        {
            speed = getSpeed +2;
        }
        if(IntroWorld.Points.getValue() == 3)
        {
            speed = getSpeed +2;
        }
     }
     
    /**
     * Returns true if the ball is touching the floor.
     */
    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - BALL_SIZE/2);
    }

    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls()
    {
        if (isTouchingSides())
        {
            if (! hasBouncedHorizontally)
            {
                revertHorizontally();
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }

    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling()
    {
        if (isTouchingCeiling())
        {
            directionUp = false;
            if (! hasBouncedVertically)
            {
                revertVertically();
                IntroWorld.Points.add(1);
                if(IntroWorld.Points.getValue() == 1){
                //Declaracion de game Over abajo de esta linea
                //Greenfoot.stop();
                }
            }
        }
        else
        {
            hasBouncedVertically = false;
            shouldTraspassEnemPaddle = true;
        }
    }
    
    /**
     * Check to see if the ball should be restarted.
     * If touching the floor the ball is restarted in initial position and speed.
     */
    private void checkRestart()
    {
        if (isTouchingFloor())
        {
            init();
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((180 - getRotation()+ randomness + 360) % 360);
        hasBouncedHorizontally = true;
    }

    /**
     * Bounces the bal back from a horizontal surface.
     */
    private void revertVertically()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((360 - getRotation()+ randomness + 360) % 360);
        hasBouncedVertically = true;
    }

    private void checkBounceOffPaddle(){
        Actor paddleZero = getOneIntersectingObject(PaddleZero.class);
        Actor enemPaddle = getOneIntersectingObject(EnemPaddle.class);
        if(paddleZero != null) {
            revertVertically();
            directionUp = !directionUp;
        }
        if(enemPaddle != null && directionUp == true) {
            revertVertically();
            
            directionUp = !directionUp;
        }
    }
}


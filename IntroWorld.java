import greenfoot.*;

public class IntroWorld extends World
{
    public static Counter Life = new Counter("Life: ");
    public static Counter Points = new Counter("Points: ");
    

    public IntroWorld()
    {
        super(500, 700, 1); 
        Greenfoot.setWorld(new Menu());
        prepare();
        Life.setValue(3);
        Points.setValue(0);
        
    }

    public void act()
    {
        String key = Greenfoot.getKey();
    }
    
    private void prepare()
    {
        BallZero ballZero = new BallZero();
        addObject(ballZero,248,346);
        EnemPaddle enemPaddle = new EnemPaddle();
        addObject(enemPaddle,251,27);
        PaddleZero paddleZero = new PaddleZero();
        addObject(paddleZero,249,660);
        enemPaddle.setLocation(264,79);
        paddleZero.setLocation(280,610);
        paddleZero.setLocation(198,637);
        enemPaddle.setLocation(340,80);
        paddleZero.setLocation(140,634);
        addObject(Life,428,659);
        addObject(Points,84,40);
    }
}

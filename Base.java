import java.util.Random;
public class Base extends Unit {

    private int tank_pawning_rate=3;
    private int helicopter_spawning_rate=4;
    Random random = new Random();
    public Base() {
        super();
    }

    public Unit generateUnit() {

        int x;
        x=random.nextInt(12)+1;
        if(x%helicopter_spawning_rate==0)
        {
            Helicopter helicopter = new Helicopter();
            return helicopter;
        }

            else if(x%tank_pawning_rate==0)
        {
            Tank tank = new Tank();
            return tank;
        }

            else
        {
            Infantry infantry = new Infantry();
            return infantry;
        }


    }




    public void setStartPoint()
    {
    	
    }
}

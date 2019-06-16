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
            helicopter.setAP(15);
            helicopter.setHP(10);
            return helicopter;
        }

            else if(x%tank_pawning_rate==0)
        {
            Tank tank = new Tank();
            tank.setAP(10);
            tank.setHP(15);
            return tank;
        }

            else
        {
            Infantry infantry = new Infantry();
            infantry.setAP(5);
            infantry.setHP(5);
            return infantry;
        }


    }




    public void setStartPoint()
    {
    	
    }
}

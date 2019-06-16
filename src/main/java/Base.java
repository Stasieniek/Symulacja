import java.util.Random;
public class Base extends Unit implements IBase {

    private int tank_pawning_rate=3;
    private int helicopter_spawning_rate=4;
    Random random = new Random();
    public Base(double HP, int name)
    {
        super();
        this.setHP(HP);
        this.setName(name);
    }

    public ISoldier generateUnit() {

        int x;
        x=random.nextInt(12)+1;
        if(x%helicopter_spawning_rate==0)
        {
            ISoldier helicopter = new Helicopter(20,15);
            return helicopter;
        }

            else if(x%tank_pawning_rate==0)
        {
            ISoldier tank = new Tank(10,25);
            return tank;
        }

            else
        {
            ISoldier infantry = new Infantry(10,10);
            return infantry;
        }


    }
}

import java.util.Random;

public class Tank extends Unit implements ISoldier  {


    Tank(double ap, double hp)
    {
        super();
        this.setAP(ap);
        this.setHP(hp);
    }
    public double attack()
    {
        int x;
        Tank tank = new Tank(15,50);
        Random random = new Random();
        x=random.nextInt(10)+1;
        if(x==5)
            return tank.getAP()*0.5;
        else
            return 0;
    }

}
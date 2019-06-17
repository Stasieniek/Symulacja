import java.util.Random;

public class Infantry extends Unit implements ISoldier  {


    Infantry(double ap, double hp)
    {
        super();
        this.setAP(ap);
        this.setHP(hp);
    }
    public double attack()
    {
        int x;
        Random random = new Random();
        x=random.nextInt(30)+1;
        if(x==5)
            return 50;
        else
            return 0;
    }
}
import java.util.Random;

public class Helicopter extends Unit implements ISoldier {

    Helicopter(double ap, double hp)
    {
        super();
        this.setAP(ap);
        this.setHP(hp);
    }
    public double attack()  /**odpowiedni dla klasy boost do ataku */
    {
        int x;
        Random random = new Random();
        x=random.nextInt(25)+1;
        if(x==15)
            return 20;
        else
            return 0;
    }
}
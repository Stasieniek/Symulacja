
public abstract class Unit  {

    private int x;
    private int y;
    private int name;
    private double hp;
    private double ap;


    public Unit() {
    }







    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getAP() {
        return ap;
    }

    public void setAP(double ap) {
        this.ap = ap;
    }
    public double getHP() {
        return hp;
    }

    public void setHP(double hp) {
        this.hp = hp;
    }



    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }



    public boolean IsAlive()
    {

        return false;
    }
    public void attack()
    {


    }



}
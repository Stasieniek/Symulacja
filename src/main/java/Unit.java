
public abstract class Unit implements IUnit  {
//podstawowe statystki każdej jednostki, a więc: baza (ta nie używa ap), tank, helicopter, infantry
    private int x;   //współrzędne jednostki na mapie
    private int y;
    private int name;
    private double hp;//punkty życia
    private double ap;//punkty ataku


    public Unit() {;}

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
    double attack()
    {
        double multiplier=0;
        return multiplier;
    }
}
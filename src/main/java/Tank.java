public class Tank extends Unit implements ISoldier  {

    Tank(double ap, double hp)
    {
        super();
        this.setAP(ap);
        this.setHP(hp);
    }

    private double armor;
    private int atMultipler;

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public void attack()
    {

    }

}
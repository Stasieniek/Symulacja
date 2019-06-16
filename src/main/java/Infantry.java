public class Infantry extends Unit implements ISoldier  {



    Infantry(double ap, double hp)
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
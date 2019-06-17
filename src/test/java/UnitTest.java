import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {
    @Test
    public void HpTest()
    {
        IUnit unit = new Tank(20,30);
        Assert.assertTrue(unit.getHP()==30);

    }
    @Test
    public void APTest()
    {
        IUnit unit = new Tank(20,30);
        Assert.assertTrue(unit.getAP()==20);


    }
    @Test
    public void XTest()
    {
        IUnit unit = new Tank(20,30);
        unit.setX(1);
        Assert.assertTrue(unit.getX()==1);


    }
    @Test
    public void YTest()
    {
        IUnit unit = new Tank(20,30);
        unit.setY(1);
        Assert.assertTrue(unit.getY()==1);

    }
    @Test
    public void NameTest()
    {
        IUnit unit = new Tank(20,30);
        unit.setName(1);
        Assert.assertTrue(unit.getName()==1);

    }
}
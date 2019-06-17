import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {
    Map map = new Map(10,9);

    @Test
    public void addBase() {

        map.addBase();
        for(int l=0;l<3;l++)
        {
            Assert.assertTrue(map.list2[l] instanceof IBase);
        }

    }

    @Test
    public void addUnit() {
        map.addBase();
        map.addUnit();

    boolean check=false;
    for(int l=0;l<10;l++)
    {
        for(int i=0;i<10;i++)
        {
            if(map.map[l][i]>0&&map.map[l][i]<=3)
            {
                check = true;
                break;
            }

        }
    }
    Assert.assertTrue(check==true);
    }

    @Test
    public void alive() {
        map.addBase();
        map.list2[0].setHP(0);
        map.list2[1].setHP(0);
        Assert.assertTrue(map.alive());
    }

}
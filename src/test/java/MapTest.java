import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {
    Map map = new Map();
    @Test
    public void getList2() {
    }

    @Test
    public void addBase() {
    }

    @Test
    public void addUnit() {


        map.addUnit();

        for(int i=0;i<3;i++)
        {
            Assert.assertTrue(map.getList2()[i] instanceof Base);
        }

    }
    @Test
    public void doFight() {


    }

    @Test
    public void show() {
    }

    @Test
    public void move() {


    }
}
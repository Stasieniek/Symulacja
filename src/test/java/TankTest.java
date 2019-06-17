import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TankTest {

    @Test
    public void attackIsDouble() {
        Tank tank = new Tank(40,20);
        Assert.assertTrue(tank.attack()<8);


    }
}
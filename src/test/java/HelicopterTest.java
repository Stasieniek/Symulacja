import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelicopterTest {

    @Test
    public void attack() {
        ISoldier helicopter = new Helicopter(20,30);
       Assert.assertTrue(helicopter.attack()<=20);
    }
}
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InfantryTest {

    @Test
    public void attack() {
        ISoldier infantry = new Infantry(10,15);
        Assert.assertTrue(infantry.attack()<=50&&infantry.attack()>=0);

    }
}
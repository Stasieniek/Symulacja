import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseTest {

    @Test
    public void generateUnit() {
        Base base = new Base(50,4);
        Assert.assertTrue(base.generateUnit()instanceof Tank||base.generateUnit()instanceof Infantry||base.generateUnit()instanceof Helicopter);

    }
}
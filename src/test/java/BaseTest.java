import org.junit.Assert;

public class BaseTest {
    public void isUnit()
    {
        Base base = new Base(50,4);
        Assert.assertTrue(base.generateUnit()instanceof Tank||base.generateUnit()instanceof Infantry||base.generateUnit()instanceof Helicopter);
    }



}

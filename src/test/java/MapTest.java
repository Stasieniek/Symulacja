import org.junit.Assert;

public class MapTest {

    public void addBaseTest()
    {
        Map map = new Map();
        map.addUnit();
        Assert.assertEquals(map.getList2().size(),3);
        for(int i=0;i<3;i++)
        {
            Assert.assertTrue(map.getList2().get(i) instanceof Base);

        }

    }

}

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("Булочка", 5);
        String actual = bun.getName();
        String expected = "Булочка";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceBunTest() {
        Bun bun = new Bun("Булочка", 5);
        float actual = bun.getPrice();
        float expected = 5;
        Assert.assertEquals(expected, actual, 0);
    }



}

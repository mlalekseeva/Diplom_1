import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;


public class IngredientTypeTest {

    @Test
    public void enumIngredientTypeTest() {
        Assert.assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
        Assert.assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

}

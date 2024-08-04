import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class IngredientTest {

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кисло-сладкий", 6);
        float actual = ingredient.getPrice();
        float expected = 6;
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кисло-сладкий", 6);
        String actual = ingredient.getName();
        String expected = "Кисло-сладкий";
        Assert.assertEquals(expected, actual);
    }
}

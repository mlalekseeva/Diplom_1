import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParamsTest {

    private final IngredientType type;

    public IngredientParamsTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[] ingredientTestData() {
        return new Object[][] {
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, "Что-то", 6);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(type, actual);
    }

}

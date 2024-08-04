import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кисло-сладкий", 6);
        Burger burger = new Burger();
        int sizeBeforeAdd = burger.ingredients.size();
        burger.addIngredient(ingredient);
        int sizeAfterAdd = burger.ingredients.size();
        Assert.assertEquals(sizeAfterAdd, sizeBeforeAdd + 1);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кисло-сладкий", 6);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int sizeBeforeRemove = burger.ingredients.size();
        burger.removeIngredient(0);
        int sizeAfterRemove = burger.ingredients.size();
        Assert.assertEquals(sizeAfterRemove, sizeBeforeRemove - 1);
        Assert.assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кисло-сладкий", 6);
        Ingredient ingredientNew = new Ingredient(IngredientType.FILLING, "Помидор", 5);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientNew);
        burger.moveIngredient(1,0);
        Assert.assertEquals(burger.ingredients.get(0), ingredientNew);
        Assert.assertEquals(burger.ingredients.get(1), ingredient);
    }

    @Mock
    Ingredient ingredient;

    @Mock
    Bun bun;

    @Test
    public void getPriceBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(8F);
        Mockito.when(ingredient.getPrice()).thenReturn(9F);
        float expected = 25;
        Assert.assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        float price = 25;
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Ржаной");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Кетчуп");
        Mockito.when(burger.getPrice()).thenReturn(price);
        Assert.assertEquals("(==== Ржаной ====)\n= sauce Кетчуп =\n(==== Ржаной ====)\n\nPrice: 25,000000\n", burger.getReceipt());
    }



}

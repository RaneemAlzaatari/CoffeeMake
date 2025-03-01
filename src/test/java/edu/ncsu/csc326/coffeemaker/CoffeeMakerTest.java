package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeMakerTest {
    private CoffeeMaker coffeeMaker;
    private Recipe recipe1, recipe2;

    @BeforeEach
    public void setUp() throws RecipeException {
        coffeeMaker = new CoffeeMaker();

        recipe1 = new Recipe();
        recipe1.setName("Espresso");
        recipe1.setPrice("50");
        recipe1.setAmtCoffee("3");
        recipe1.setAmtMilk("0");
        recipe1.setAmtSugar("1");
        recipe1.setAmtChocolate("0");

        recipe2 = new Recipe();
        recipe2.setName("Latte");
        recipe2.setPrice(String.valueOf(75));
        recipe2.setAmtCoffee("2");
        recipe2.setAmtMilk("2");
        recipe2.setAmtSugar("2");
        recipe2.setAmtChocolate("0");
    }

    @Test
    public void testAddRecipe() {
        assertTrue(coffeeMaker.addRecipe(recipe1));
    }

    @Test
    public void testDeleteRecipe() {
        coffeeMaker.addRecipe(recipe1);
        assertEquals("Espresso", coffeeMaker.deleteRecipe(0));
    }

    @Test
    public void testEditRecipe() {
        coffeeMaker.addRecipe(recipe1);
        assertEquals("Espresso", coffeeMaker.editRecipe(0, recipe2));
    }

    @Test
    public void testAddInventorySuccess() throws InventoryException {
        coffeeMaker.addInventory("5", "5", "5", "5");
    }

    @Test
    public void testAddInventoryFailure() throws InventoryException {
        coffeeMaker.addInventory("-5", "5", "5", "5");
    }

    @Test
    public void testCheckInventory() {
        assertNotNull(coffeeMaker.checkInventory());
    }

    @Test
    public void testMakeCoffeeSuccess() {
        coffeeMaker.addRecipe(recipe1);
        assertEquals(50, coffeeMaker.makeCoffee(0, 100));
    }

    @Test
    public void testMakeCoffeeInsufficientFunds() {
        coffeeMaker.addRecipe(recipe1);
        assertEquals(30, coffeeMaker.makeCoffee(0, 30));
    }

    @Test
    public void testMakeCoffeeInsufficientIngredients() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.makeCoffee(0, 100);
        assertEquals(100, coffeeMaker.makeCoffee(0, 100));
    }
}

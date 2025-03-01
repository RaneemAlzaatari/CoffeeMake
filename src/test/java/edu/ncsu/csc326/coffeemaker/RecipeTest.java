package edu.ncsu.csc326.coffeemaker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class RecipeTest {
    private Recipe recipe;

    @BeforeEach
    public void setUp() {
        recipe = new Recipe();
    }

    @Test
    public void testSetAmtChocolateValid() throws RecipeException {
        recipe.setAmtChocolate("5");
        assertEquals(5, recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolateInvalid() throws RecipeException {
        recipe.setAmtChocolate("-1");
    }

    @Test
    public void testSetAmtChocolateNonNumeric() throws RecipeException {
        recipe.setAmtChocolate("abc");
    }

    @Test
    public void testSetAmtCoffeeValid() throws RecipeException {
        recipe.setAmtCoffee("3");
        assertEquals(3, recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffeeInvalid() throws RecipeException {
        recipe.setAmtCoffee("-2");
    }

    @Test
    public void testSetAmtCoffeeNonNumeric() throws RecipeException {
        recipe.setAmtCoffee("xyz");
    }

    @Test
    public void testSetAmtMilkValid() throws RecipeException {
        recipe.setAmtMilk("2");
        assertEquals(2, recipe.getAmtMilk());
    }

    @Test
    public void testSetAmtMilkInvalid() throws RecipeException {
        recipe.setAmtMilk("-3");
    }

    @Test
    public void testSetAmtMilkNonNumeric() throws RecipeException {
        recipe.setAmtMilk("milk");
    }

    @Test
    public void testSetAmtSugarValid() throws RecipeException {
        recipe.setAmtSugar("4");
        assertEquals(4, recipe.getAmtSugar());
    }

    @Test
    public void testSetAmtSugarInvalid() throws RecipeException {
        recipe.setAmtSugar("-4");
    }

    @Test
    public void testSetAmtSugarNonNumeric() throws RecipeException {
        recipe.setAmtSugar("sugar");
    }

    @Test
    public void testSetPriceValid() throws RecipeException {
        recipe.setPrice("10");
        assertEquals(10, recipe.getPrice());
    }

    @Test
    public void testSetPriceInvalid() throws RecipeException {
        recipe.setPrice("-10");
    }

    @Test
    public void testSetPriceNonNumeric() throws RecipeException {
        recipe.setPrice("ten");
    }

    @Test
    public void testSetName() {
        recipe.setName("Latte");
        assertEquals("Latte", recipe.getName());
    }

    @Test
    public void testSetNameNull() {
        recipe.setName(null);
        assertNotNull(recipe.getName()); // Should not be null, default is ""
    }

    @Test
    public void testEquals() {
        Recipe recipe2 = new Recipe();
        recipe.setName("Espresso");
        recipe2.setName("Espresso");
        assertTrue(recipe.equals(recipe2));
    }

    @Test
    public void testNotEquals() {
        Recipe recipe2 = new Recipe();
        recipe.setName("Espresso");
        recipe2.setName("Cappuccino");
        assertFalse(recipe.equals(recipe2));
    }
}

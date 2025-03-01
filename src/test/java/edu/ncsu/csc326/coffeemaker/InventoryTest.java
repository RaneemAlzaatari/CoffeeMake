package edu.ncsu.csc326.coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testInitialInventory() {
        assertEquals(15, inventory.getCoffee());
        assertEquals(15, inventory.getMilk());
        assertEquals(15, inventory.getSugar());
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testAddValidCoffee() throws InventoryException {
        inventory.addCoffee("5");
        assertEquals(20, inventory.getCoffee());
    }

    @Test
    public void testAddInvalidCoffee() throws InventoryException {
        inventory.addCoffee("-5");
    }

    @Test
    public void testAddNonNumericCoffee() throws InventoryException {
        inventory.addCoffee("abc");
    }

    @Test
    public void testAddValidMilk() throws InventoryException {
        inventory.addMilk("5");
        assertEquals(20, inventory.getMilk());
    }

    @Test
    public void testAddInvalidMilk() throws InventoryException {
        inventory.addMilk("-5");
    }

    @Test
    public void testAddNonNumericMilk() throws InventoryException {
        inventory.addMilk("xyz");
    }

    @Test
    public void testAddValidSugar() throws InventoryException {
        inventory.addSugar("5");
        assertEquals(20, inventory.getSugar());
    }

    @Test
    public void testAddInvalidSugar() throws InventoryException {
        inventory.addSugar("-5");
    }

    @Test
    public void testAddNonNumericSugar() throws InventoryException {
        inventory.addSugar("123abc");
    }

    @Test
    public void testAddValidChocolate() throws InventoryException {
        inventory.addChocolate("5");
        assertEquals(20, inventory.getChocolate());
    }

    @Test
    public void testAddInvalidChocolate() throws InventoryException {
        inventory.addChocolate("-5");
    }

    @Test
    public void testAddNonNumericChocolate() throws InventoryException {
        inventory.addChocolate("$#");
    }

    @Test
    public void testUseIngredientsSufficient() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee("5");
        recipe.setAmtMilk("5");
        recipe.setAmtSugar("5");
        recipe.setAmtChocolate("5");
        assertTrue(inventory.useIngredients(recipe));
    }

    @Test
    public void testUseIngredientsInsufficient() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee("20");
        assertFalse(inventory.useIngredients(recipe));
    }
}

package edu.ncsu.csc326.coffeemaker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipeBookTest {
    private RecipeBook recipeBook;
    private Recipe recipe1;
    private Recipe recipe2;

    @BeforeEach
    void setUp() {
        recipeBook = new RecipeBook();
        recipe1 = new Recipe();
        recipe1.setName("Espresso");
        recipe2 = new Recipe();
        recipe2.setName("Latte");
    }

    @Test
    void testAddRecipeSuccess() {
        assertTrue(recipeBook.addRecipe(recipe1), "Should successfully add a recipe");
    }

    @Test
    void testAddDuplicateRecipe() {
        recipeBook.addRecipe(recipe1);
        assertFalse(recipeBook.addRecipe(recipe1), "Should not allow adding duplicate recipes");
    }

    @Test
    void testAddRecipeBeyondLimit() {
        for (int i = 0; i < 4; i++) {
            Recipe r = new Recipe();
            r.setName("Recipe" + i);
            recipeBook.addRecipe(r);
        }
        assertFalse(recipeBook.addRecipe(recipe2), "Should not allow adding more than 4 recipes");
    }

    @Test
    void testDeleteExistingRecipe() {
        recipeBook.addRecipe(recipe1);
        assertEquals("Espresso", recipeBook.deleteRecipe(0), "Should return deleted recipe name");
    }

    @Test
    void testDeleteNonExistentRecipe() {
        assertNull(recipeBook.deleteRecipe(0), "Should return null when deleting a non-existent recipe");
    }

    @Test
    void testEditExistingRecipe() {
        recipeBook.addRecipe(recipe1);
        assertEquals("Espresso", recipeBook.editRecipe(0, recipe2), "Should return old recipe name when edited");
    }

    @Test
    void testEditNonExistentRecipe() {
        assertNull(recipeBook.editRecipe(0, recipe2), "Should return null when editing a non-existent recipe");
    }
}

package com.formos.smoothie_vendor.util;

import com.formos.smoothie_vendor.Inventory;
import com.formos.smoothie_vendor.constant.IngredientRecipe;
import com.formos.smoothie_vendor.error.LowIngredientQuantityException;
import com.formos.smoothie_vendor.error.NotEnoughIngredientQuantityException;
import com.formos.smoothie_vendor.constant.Ingredient;

public class ValidateUtil {

    private static Inventory inventory;
    private ValidateUtil() {}

    public static void checkCommon(int quantity) {
        inventory = Inventory.getInstance();
        if (inventory.getIngredientQuantity(Ingredient.FRUIT) < (IngredientRecipe.FRUIT * quantity)) {
            throw new NotEnoughIngredientQuantityException(Ingredient.FRUIT);
        }
        if (inventory.getIngredientQuantity(Ingredient.ICE) < (IngredientRecipe.ICE * quantity)) {
            throw new NotEnoughIngredientQuantityException(Ingredient.ICE);
        }
        if (inventory.getIngredientQuantity(Ingredient.CONDENSED_MILK) < (IngredientRecipe.CONDENSED_MILK * quantity)) {
            throw new NotEnoughIngredientQuantityException(Ingredient.CONDENSED_MILK);
        }
        if (inventory.getIngredientQuantity(Ingredient.SUGAR) < IngredientRecipe.SUGAR) {
            throw new NotEnoughIngredientQuantityException(Ingredient.SUGAR);
        }
    }
    public static void checkStrawberry (int quantity) {
        inventory = Inventory.getInstance();
        checkCommon(quantity);
        if (inventory.getIngredientQuantity(Ingredient.STRAWBERRY) < (IngredientRecipe.STRAWBERRY * quantity)) {
            throw new NotEnoughIngredientQuantityException(Ingredient.STRAWBERRY);
        }
    }

    public static void checkBanana(int quantity) {
        inventory = Inventory.getInstance();
        checkCommon(quantity);
        if (inventory.getIngredientQuantity(Ingredient.BANANA) < (IngredientRecipe.BANANA * quantity)) {
            throw new NotEnoughIngredientQuantityException(Ingredient.BANANA);
        }
    }

    public static void checkMango(int quantity) {
        inventory = Inventory.getInstance();
        checkCommon(quantity);
        if (inventory.getIngredientQuantity(Ingredient.MANGO) < (IngredientRecipe.MANGO * quantity)) {
            throw new NotEnoughIngredientQuantityException(Ingredient.MANGO);
        }
    }

    public static void checkInventory(int quantity) {
        inventory = Inventory.getInstance();
        if (inventory.getIngredientQuantity(Ingredient.FRUIT) < (IngredientRecipe.FRUIT * quantity)) {
            throw new LowIngredientQuantityException(Ingredient.FRUIT);
        }
        if (inventory.getIngredientQuantity(Ingredient.ICE) < (IngredientRecipe.ICE * quantity)) {
            throw new LowIngredientQuantityException(Ingredient.ICE);
        }
        if (inventory.getIngredientQuantity(Ingredient.CONDENSED_MILK) < (IngredientRecipe.CONDENSED_MILK * quantity)) {
            throw new LowIngredientQuantityException(Ingredient.CONDENSED_MILK);
        }
        if (inventory.getIngredientQuantity(Ingredient.SUGAR) < IngredientRecipe.SUGAR) {
            throw new LowIngredientQuantityException(Ingredient.SUGAR);
        }
        if (inventory.getIngredientQuantity(Ingredient.STRAWBERRY) < (IngredientRecipe.STRAWBERRY * quantity)) {
            throw new LowIngredientQuantityException(Ingredient.STRAWBERRY);
        }
        if (inventory.getIngredientQuantity(Ingredient.BANANA) < (IngredientRecipe.BANANA * quantity)) {
            throw new LowIngredientQuantityException(Ingredient.BANANA);
        }
        if (inventory.getIngredientQuantity(Ingredient.MANGO) < (IngredientRecipe.MANGO * quantity)) {
            throw new LowIngredientQuantityException(Ingredient.MANGO);
        }
    }
}

package com.formos.smoothie_vendor.util;

import com.formos.smoothie_vendor.Inventory;
import com.formos.smoothie_vendor.constant.Ingredient;
import com.formos.smoothie_vendor.constant.IngredientRecipe;

import java.util.HashMap;
import java.util.Map;

public class AppUtil {

    private AppUtil() {}

    public static Map<Ingredient, Integer> makeCommon(int quantity) {
        Map<Ingredient, Integer> spentIngredients = new HashMap<>();
        Integer spentFruit = IngredientRecipe.FRUIT * quantity;
        int spentIce = IngredientRecipe.ICE * quantity;
        int spentCondensedMilk = IngredientRecipe.CONDENSED_MILK * quantity;
        int spentSugar = IngredientRecipe.SUGAR * quantity;
        Inventory inventory = Inventory.getInstance();

        inventory.reduceIngredient(Ingredient.FRUIT, spentFruit);
        spentIngredients.put(Ingredient.FRUIT, spentFruit);

        inventory.reduceIngredient(Ingredient.ICE, spentIce);
        spentIngredients.put(Ingredient.ICE, spentIce);

        inventory.reduceIngredient(Ingredient.CONDENSED_MILK, spentCondensedMilk);
        spentIngredients.put(Ingredient.CONDENSED_MILK, spentCondensedMilk);

        inventory.reduceIngredient(Ingredient.SUGAR, spentSugar);
        spentIngredients.put(Ingredient.SUGAR, spentSugar);

        return spentIngredients;
    }
    public static Map<Ingredient, Integer> makeStrawberrySmoothie (int quantity) {
        Inventory inventory = Inventory.getInstance();
        ValidateUtil.checkStrawberry(quantity);
        Integer spentStrawberry = IngredientRecipe.STRAWBERRY * quantity;
        Map<Ingredient, Integer> spentIngredients = makeCommon(quantity);
        inventory.reduceIngredient(Ingredient.STRAWBERRY, spentStrawberry);
        spentIngredients.put(Ingredient.STRAWBERRY, spentStrawberry);
        return spentIngredients;
    }

    public static Map<Ingredient, Integer> makeBananaSmoothie(int quantity) {
        Inventory inventory = Inventory.getInstance();
        ValidateUtil.checkBanana(quantity);
        Integer spentBanana = IngredientRecipe.BANANA * quantity;
        Map<Ingredient, Integer> spentIngredients = makeCommon(quantity);
        inventory.reduceIngredient(Ingredient.BANANA, spentBanana);
        spentIngredients.put(Ingredient.BANANA, spentBanana);
        return spentIngredients;
    }

    public static Map<Ingredient, Integer> makeMangoSmoothie(int quantity) {
        Inventory inventory = Inventory.getInstance();
        ValidateUtil.checkMango(quantity);
        Integer spentMango = IngredientRecipe.MANGO * quantity;
        Map<Ingredient, Integer> spentIngredients = makeCommon(quantity);
        inventory.reduceIngredient(Ingredient.MANGO, spentMango);
        spentIngredients.put(Ingredient.MANGO, spentMango);
        return spentIngredients;
    }
}

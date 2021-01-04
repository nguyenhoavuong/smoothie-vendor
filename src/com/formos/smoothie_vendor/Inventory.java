package com.formos.smoothie_vendor;

import com.formos.smoothie_vendor.constant.Ingredient;
import com.formos.smoothie_vendor.constant.IngredientQuantity;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Ingredient, Integer> ingredients;
    private static Inventory instance;

    private Inventory() {}

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
            instance.initIngredients();
        }
        return instance;
    }

    public void initIngredients() {
        ingredients = new HashMap<>();
        ingredients.put(Ingredient.FRUIT, IngredientQuantity.FRUIT);
        ingredients.put(Ingredient.ICE, IngredientQuantity.ICE);
        ingredients.put(Ingredient.CONDENSED_MILK, IngredientQuantity.CONDENSED_MILK);
        ingredients.put(Ingredient.SUGAR, IngredientQuantity.SUGAR);
        ingredients.put(Ingredient.STRAWBERRY, IngredientQuantity.STRAWBERRY);
        ingredients.put(Ingredient.BANANA, IngredientQuantity.BANANA);
        ingredients.put(Ingredient.MANGO, IngredientQuantity.MANGO);
    }

    public void setIngredientQuantity(Ingredient ingredient, Integer quantity) {
        ingredients.put(ingredient, quantity);
    }

    public Integer getIngredientQuantity(Ingredient ingredient) {
        return ingredients.get(ingredient);
    }

    public void reduceIngredient(Ingredient ingredient, Integer quantity) {
        int ingredientQuantity = ingredients.get(ingredient);
        ingredients.put(ingredient, ingredientQuantity - quantity);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Inventory: ");
        for(Map.Entry<Ingredient, Integer> entry: ingredients.entrySet()) {
            stringBuilder.append("\n" + entry.getKey().name() + ": " + entry.getValue());
        }
        return stringBuilder.toString();
    }
}

package com.formos.smoothie_vendor.error;

import com.formos.smoothie_vendor.constant.Ingredient;

public class LowIngredientQuantityException extends RuntimeException {
    private Ingredient ingredient;
    public LowIngredientQuantityException(Ingredient ingredient) {
        super(String.format("Low %s. Please add more", ingredient.name()));
        this.ingredient = ingredient;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}

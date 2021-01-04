package com.formos.smoothie_vendor.error;

import com.formos.smoothie_vendor.constant.Ingredient;

public class NotEnoughIngredientQuantityException extends RuntimeException {
    private Ingredient ingredient;
    public NotEnoughIngredientQuantityException(Ingredient ingredient) {
        super(String.format("Not enough %s", ingredient.name()));
        this.ingredient = ingredient;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}

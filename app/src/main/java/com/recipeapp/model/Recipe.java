package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe {
    private String name;//レシピの名前
    private ArrayList<Ingredient> ingredients = new ArrayList<>();//レシピの材料リスト


    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }


    public String getName() {
        //getNameされたらレシピ名を返す
        return name;
    }


    public ArrayList<Ingredient> getIngredients() {
        //getIngredientsされたら材料リストを返す
        return ingredients;
    }
}

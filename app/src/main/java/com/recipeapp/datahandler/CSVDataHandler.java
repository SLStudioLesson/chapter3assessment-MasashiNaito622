package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import com.recipeapp.model.Recipe;
import com.recipeapp.model.Ingredient;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMode() {
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        //recipes.csvから読み込んだデータをリスト化する
        ArrayList<Recipe> recipes = new ArrayList<>();
        //ファイルの読み込み
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length < 2) continue;

                String name = parts[0];
                String[] ingredientsArray = parts[1].split(",");
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                for (String ingredient : ingredientsArray) {
                    Ingredient ingredient2 = new Ingredient(ingredient);
                    ingredients.add(ingredient2);
                }

                Recipe recipe = new Recipe(name, ingredients);
                recipes.add(recipe);
            }
        }
        return recipes;
    }
    

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
        // 実装は後で行います
        
    }
}
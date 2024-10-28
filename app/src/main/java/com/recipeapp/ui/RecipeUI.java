package com.recipeapp.ui;
//各種インポート
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    //RecipeUIのdisplayRecipesメソッドのアクセス修飾子はprivateで定義
    private void displayRecipes() throws IOException{
        try {
            ArrayList<Recipe> recipes = dataHandler.readData();
            //空の時はNo recipes available.と出力
            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
            } else {
                //空じゃないとき
                System.out.println("Recipes:");
                System.out.println("-----------------------------------");
                for (Recipe recipe : recipes) {
                    //レシピインスタンスから名前をとってくる
                    System.out.println("Recipe Name: " + recipe.getName());

                    // 材料リストを取得し、カンマ区切りで出力
                    ArrayList<String> ingredientNames = new ArrayList<>();
                    for (Ingredient ingredient : recipe.getIngredients()) {
                        ingredientNames.add(ingredient.getName());
                    }
                    // 1つ1つバラバラの材料を、新しいリストに1つの文字列として登録する
                    String ingredientsList = String.join(", ", ingredientNames);
                    String message = "Main Ingredients: " + ingredientsList;
                    System.out.println(message);

                System.out.println("-----------------------------------");
                }
            }
        }catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }
    //addNewRecipe メソッド
    private void addNewRecipe() {
        try{
            //ユーザーからレシピ名と主な材料を入力を受け付ける
            //レシピ名を受け付け
            System.out.println("Adding a new recipe.");
            System.out.print("Enter recipe name: ");
            String name = reader.readLine();

            //材料名を受け付け
            ArrayList<Ingredient>ingredients = new ArrayList<>();
            System.out.println("Enter ingredients (type 'done' when finished):");
            while(true){
                System.out.print("Ingredient: ");
                String ingredient = reader.readLine();

                //doneが入力されるまで、材料を入力 doneが入ったら終了
                if("done".equals(ingredient)){
                    break;
                }
                //入力された材料を入力
                Ingredient ingredientParts = new Ingredient(ingredient);
                ingredients.add(ingredientParts);
            }
            //レシピ名とリスト化された材料名を持ったインスタンスを生成する
            Recipe recipe = new Recipe(name,ingredients);
            //レシピデータに書き込みを加える
            dataHandler.writeData(recipe);
            //入力成功を伝える
            System.out.println("Recipe added successfully.");



        }catch(IOException ex){//IOExceptionを受け取った場合はFailed to add new recipe: 例外のメッセージとコンソールに表示
            System.out.println("Failed to add new recipe: "+ ex.getMessage());
        }

    }

    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();//displayRecipes を呼び出す
                        break;
                    case "2":
                        addNewRecipe();//addNewRecipeを呼び出す
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }
}
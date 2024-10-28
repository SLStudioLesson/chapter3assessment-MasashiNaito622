package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class JSONDataHandler implements DataHandler{

    @Override
    public String getMode() {
        //文字列JSONを返す
        return "JSON";
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        //処理の実装は行わないので定義し、nullをreturnしてください
        return null;
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        //処理の実装は行わないので定義し、nullをreturnしてください
        return null;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
        //処理の実装は行わないので定義のみ行います
    }
    
}
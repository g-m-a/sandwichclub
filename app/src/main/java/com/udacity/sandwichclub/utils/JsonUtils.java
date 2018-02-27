package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject object = new JSONObject(json);

            JSONObject name = object.getJSONObject("name");
            sandwich.setMainName(name.getString("mainName"));

            JSONArray aka = name.getJSONArray("alsoKnownAs");
            List<String> names = new ArrayList<String>();;
            if(aka!=null && aka.length()>0){
                for (int i=0;i<aka.length();i++){
                    names.add(aka.getString(i));
                }
            }
            sandwich.setAlsoKnownAs(names);

            sandwich.setPlaceOfOrigin(object.getString("placeOfOrigin"));

            sandwich.setDescription(object.getString("description"));

            sandwich.setImage(object.getString("image"));

            JSONArray mats = object.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<String>();
            if (mats!=null && mats.length()>0){
                for(int i=0;i<mats.length();i++){
                    ingredients.add(mats.getString(i));
                }
            }

            sandwich.setIngredients(ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return sandwich;
    }
}

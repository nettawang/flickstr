package com.codepath.flickstr.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nettawang on 6/22/17.
 */

public class Config {
    //the base url for loading images
    String imageBaseURL;
    //the poster size to use when fetching images, part of the url
    String posterSize;

    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        //get image base url
        imageBaseURL = images.getString("secure_base_url");
        //get poster size
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        // use the option at index 3 or w342 as a fallback
        posterSize = posterSizeOptions.optString(3, "w342");
    }

    //helper method for creating urls

    public String getImageURL (String size, String path){
        return String.format("%s%s%s", imageBaseURL, size, path); //concatenate all three
    }

    public String getImageBaseURL() {
        return imageBaseURL;
    }

    public String getPosterSize() {
        return posterSize;
    }
}

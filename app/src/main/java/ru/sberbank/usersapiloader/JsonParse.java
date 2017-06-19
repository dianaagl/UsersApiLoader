package ru.sberbank.usersapiloader;


import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Random;

/**
 * Created by user8 on 23.05.2017.
 */
@SuppressWarnings("ALL")
public class JsonParse {
    private static final Random RANDOM = new Random();

    public static User createUserFromArray(JSONArray jsonArray) throws JSONException {

        int index = Math.abs(RANDOM.nextInt()) % jsonArray.size();
        String login = ((JSONObject) jsonArray.get(index)).getOrDefault("login", "login").toString();
        Long id = (Long) ((JSONObject) jsonArray.get(index)).getOrDefault("id", 0);
        String urlStr = ((JSONObject) jsonArray.get(index)).getOrDefault("url", "url").toString();
        String htmlUrl = ((JSONObject) jsonArray.get(index)).getOrDefault("html_url", "html_url").toString();

        User cacheUser = new User(login, id, urlStr, htmlUrl);
        return cacheUser;
    }

}

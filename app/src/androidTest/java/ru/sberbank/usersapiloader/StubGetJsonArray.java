package ru.sberbank.usersapiloader;

import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Диана on 19.06.2017.
 */
public class StubGetJsonArray implements loadJson {
    private static final int SIZE = 10;
    private static final int START_CHAR = (int) 'A';
    private static final int END_CHAR = (int) 'Z';
    private static final Random RANDOM = new Random();

    protected static String createRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            int value = START_CHAR + RANDOM.nextInt(
                    END_CHAR - START_CHAR
            );
            sb.append((char) value);
        }
        return sb.toString();
    }

    public JSONArray getJsonArray() throws JSONException {
        JSONObject jsonObjectLogin = new JSONObject();
        jsonObjectLogin.put("login",createRandomString());
        JSONObject jsonObjectId = new JSONObject();
        jsonObjectId.put("id",createRandomString());
        JSONObject jsonObjectUrl = new JSONObject();
        jsonObjectUrl.put("url","http://"+createRandomString());
        JSONObject jsonObjectHtmlUrl = new JSONObject();
        jsonObjectHtmlUrl.put("html_url","http://"+ createRandomString());

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObjectLogin);
        jsonArray.add(jsonObjectId);
        jsonArray.add(jsonObjectUrl);
        jsonArray.add(jsonObjectHtmlUrl);
        return jsonArray;
    }


}

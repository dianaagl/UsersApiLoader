package ru.sberbank.usersapiloader;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Диана on 19.06.2017.
 */
public interface loadJson {
    public JSONArray getJsonArray() throws IOException, ParseException, JSONException;
}

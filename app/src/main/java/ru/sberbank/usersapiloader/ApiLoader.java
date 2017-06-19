package ru.sberbank.usersapiloader;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Диана on 19.06.2017.
 */
public class ApiLoader implements loadJson {
    @Override
    public JSONArray getJsonArray() throws IOException, ParseException {
        URL url = null;//new URL("https://api.github.com/users?");
        HttpURLConnection urlConnection = null;
        User user = null;
        JSONArray jsonArray = null;

        try {
            url = new URL("https://api.github.com/users?");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            JSONParser jsonParser = new JSONParser();
            jsonArray = (JSONArray)jsonParser.parse(
                    new InputStreamReader(in, "UTF-8"));


        } catch (IOException e) {

        } catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }

        return  jsonArray;

    }
}

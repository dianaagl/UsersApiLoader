package ru.sberbank.usersapiloader;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.util.Log;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;


/**
 * Created by user8 on 23.05.2017.
 */

@SuppressWarnings("ALL")
public class UserLoader extends AsyncTaskLoader <User>{
    private User cache;
    private final static String TAG ="Loader";
    final Random rand = new Random();
    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public UserLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        Log.e(TAG,"onSTartLoading");

        forceLoad();
    }



    @Override
    public User loadInBackground() {

            Log.e(TAG,"load in background");

            URL url = null;//new URL("https://api.github.com/users?");
            HttpURLConnection urlConnection = null;
            try {
                url = new URL("https://api.github.com/users?");
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                JSONParser jsonParser = new JSONParser();
                JSONArray jsonArray = (JSONArray)jsonParser.parse(
                        new InputStreamReader(in, "UTF-8"));
                int index = Math.abs(rand.nextInt())%jsonArray.size();
                String login = ((JSONObject)jsonArray.get(index)).getOrDefault("login","login").toString();
                Long id = (Long) ((JSONObject)jsonArray.get(index)).getOrDefault("id",0);
                String urlStr = ((JSONObject)jsonArray.get(index)).getOrDefault("url","url").toString();
                String htmlUrl = ((JSONObject)jsonArray.get(index)).getOrDefault("html_url","html_url").toString();
                Log.e(TAG,"login="+ login);
                return new User(login,id,urlStr,htmlUrl);

            } catch (IOException e) {

            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }

            return null;

    }

}

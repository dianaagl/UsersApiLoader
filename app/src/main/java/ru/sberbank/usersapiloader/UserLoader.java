package ru.sberbank.usersapiloader;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;


/**
 * Created by user8 on 23.05.2017.
 */

@SuppressWarnings("ALL")
public class UserLoader extends AsyncTaskLoader <User>{
    private final static String TAG ="Loader";
    private loadJson loadJson;
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
    public UserLoader(Context context, loadJson loadJsonTemp) {

        super(context);
        loadJson = loadJsonTemp;
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


        User user = null;
        try {
            user = JsonParse.createUserFromArray(loadJson.getJsonArray());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return user;

    }

}

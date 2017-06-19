package ru.sberbank.usersapiloader;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static int USER_LOADER_ID = 1;
    private final static String TAG = "main";
    private TextView loginView;
    private TextView id_view;
    private TextView urlView;
    private TextView htmlUrlView;
    private Button newUserBut;
    private UserLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginView = (TextView) findViewById(R.id.login);
        id_view = (TextView) findViewById(R.id.id);
        urlView = (TextView) findViewById(R.id.url1);
        htmlUrlView = (TextView) findViewById(R.id.url2);
        newUserBut = (Button) findViewById(R.id.new_user_but);

        getSupportLoaderManager().initLoader(USER_LOADER_ID, null, new LoaderCallback());
        newUserBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loader.onContentChanged();
            }
        });
    }
    private class LoaderCallback implements LoaderManager.LoaderCallbacks<User> {

        @Override
        public Loader<User> onCreateLoader(int id, Bundle args) {
            loadJson apiLoader = new ApiLoader();

            loader  = new UserLoader(MainActivity.this, apiLoader);
            return loader;
        }

        @Override
        public void onLoadFinished(Loader<User> loader, User data) {
            if (data != null) {
                loginView.setText(data.getLogin());
                id_view.setText(String.valueOf(data.getId()));
                urlView.setText(data.getUrl());
                htmlUrlView.setText(data.getHtml_url());
                Log.e(TAG, data.getLogin());
                // id_view.setText(data.getId());

            }
        }

        @Override
        public void onLoaderReset(Loader<User> loader) {

        }
    }
}

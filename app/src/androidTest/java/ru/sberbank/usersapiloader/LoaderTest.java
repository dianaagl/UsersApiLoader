package ru.sberbank.usersapiloader;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

/**
 * Created by Диана on 19.06.2017.
 */
public class LoaderTest implements LoaderManager.LoaderCallbacks<User> {

    @Override
    public Loader<User> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<User> loader, User data) {

    }

    @Override
    public void onLoaderReset(Loader<User> loader) {

    }
}

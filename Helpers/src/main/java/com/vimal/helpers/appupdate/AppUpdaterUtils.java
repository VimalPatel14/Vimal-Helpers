/*
 * Copyright (C) 2021 Vimal Patel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vimal.helpers.appupdate;

import android.content.Context;

import androidx.annotation.NonNull;

import com.vimal.helpers.appupdate.enums.AppUpdaterError;
import com.vimal.helpers.appupdate.enums.UpdateFrom;
import com.vimal.helpers.appupdate.objects.GitHub;
import com.vimal.helpers.appupdate.objects.Update;

public class AppUpdaterUtils {
    private Context context;
    private UpdateListener updateListener;
    private AppUpdaterListener appUpdaterListener;
    private UpdateFrom updateFrom;
    private GitHub gitHub;
    private String xmlOrJSONUrl;
    private UtilsAsync.LatestAppVersion latestAppVersion;

    public interface UpdateListener {
       
        void onSuccess(Update update, Boolean isUpdateAvailable);

        void onFailed(AppUpdaterError error);
    }

    @Deprecated
    public interface AppUpdaterListener {
        /**
         * onSuccess method called after it is successful
         * onFailed method called if it can't retrieve the latest version
         *
         * @param latestVersion     available in the provided source
         * @param isUpdateAvailable compare installed version with the latest one
         */
        void onSuccess(String latestVersion, Boolean isUpdateAvailable);

        void onFailed(AppUpdaterError error);
    }

    public AppUpdaterUtils(Context context) {
        this.context = context;
        this.updateFrom = UpdateFrom.GOOGLE_PLAY;
    }

   
    public AppUpdaterUtils setUpdateFrom(UpdateFrom updateFrom) {
        this.updateFrom = updateFrom;
        return this;
    }

    /**
     * Set the user and repo where the releases are uploaded. You must upload your updates as a release in order to work properly tagging them as vX.X.X or X.X.X.
     *
     * @param user GitHub user
     * @param repo GitHub repository
     * @return this
     */
    public AppUpdaterUtils setGitHubUserAndRepo(String user, String repo) {
        this.gitHub = new GitHub(user, repo);
        return this;
    }

    /**
     * Set the url to the xml with the latest version info.
     *
     * @param xmlUrl file
     * @return this
     */
    public AppUpdaterUtils setUpdateXML(@NonNull String xmlUrl) {
        this.xmlOrJSONUrl = xmlUrl;
        return this;
    }

    /**
     * Set the url to the xml with the latest version info.
     *
     * @param jsonUrl file
     * @return this
     */
    public AppUpdaterUtils setUpdateJSON(@NonNull String jsonUrl) {
        this.xmlOrJSONUrl = jsonUrl;
        return this;
    }


    /**
     * Method to set the AppUpdaterListener for the AppUpdaterUtils actions
     *
     * @param appUpdaterListener the listener to be notified
     * @return this
     * @see AppUpdaterUtils.AppUpdaterListener
     * @deprecated
     */
    public AppUpdaterUtils withListener(AppUpdaterListener appUpdaterListener) {
        this.appUpdaterListener = appUpdaterListener;
        return this;
    }

    /**
     * Method to set the UpdateListener for the AppUpdaterUtils actions
     *
     * @param updateListener the listener to be notified
     * @return this
     * @see AppUpdaterUtils.UpdateListener
     */
    public AppUpdaterUtils withListener(UpdateListener updateListener) {
        this.updateListener = updateListener;
        return this;
    }

    /**
     * Execute AppUpdaterUtils in background.
     */
    public void start() {
        latestAppVersion = new UtilsAsync.LatestAppVersion(context, true, updateFrom, gitHub, xmlOrJSONUrl, new AppUpdater.LibraryListener() {
            @Override
            public void onSuccess(Update update) {
                Update installedUpdate = new Update(UtilsLibrary.getAppInstalledVersion(context), UtilsLibrary.getAppInstalledVersionCode(context));

                if (updateListener != null) {
                    updateListener.onSuccess(update, UtilsLibrary.isUpdateAvailable(installedUpdate, update));
                } else if (appUpdaterListener != null) {
                    appUpdaterListener.onSuccess(update.getLatestVersion(), UtilsLibrary.isUpdateAvailable(installedUpdate, update));
                } else {
                    throw new RuntimeException("You must provide a listener for the AppUpdaterUtils");
                }
            }

            @Override
            public void onFailed(AppUpdaterError error) {
                if (updateListener != null) {
                    updateListener.onFailed(error);
                } else if (appUpdaterListener != null) {
                    appUpdaterListener.onFailed(error);
                } else {
                    throw new RuntimeException("You must provide a listener for the AppUpdaterUtils");
                }
            }
        });

        latestAppVersion.execute();
    }

    /**
     * Stops the execution of AppUpdater.
     */
    public void stop() {
        if (latestAppVersion != null && !latestAppVersion.isCancelled()) {
            latestAppVersion.cancel(true);
        }
    }
}

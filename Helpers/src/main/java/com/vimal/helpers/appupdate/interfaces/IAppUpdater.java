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
package com.vimal.helpers.appupdate.interfaces;

import android.content.DialogInterface;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import com.vimal.helpers.appupdate.AppUpdater;
import com.vimal.helpers.appupdate.enums.AppUpdaterError;
import com.vimal.helpers.appupdate.enums.Display;
import com.vimal.helpers.appupdate.enums.Duration;
import com.vimal.helpers.appupdate.enums.UpdateFrom;
import com.vimal.helpers.appupdate.objects.Update;

public interface IAppUpdater {

    AppUpdater setDisplay(Display display);


    AppUpdater setUpdateFrom(UpdateFrom updateFrom);


    AppUpdater setDuration(Duration duration);

    /**
     * Set the user and repo where the releases are uploaded. You must upload your updates as a release in order to work properly tagging them as vX.X.X or X.X.X.
     *
     * @param user GitHub user
     * @param repo GitHub repository
     * @return this
     */
    AppUpdater setGitHubUserAndRepo(@NonNull String user, @NonNull String repo);

    /**
     * Set the url to the xml file with the latest version info.
     *
     * @param xmlUrl file
     * @return this
     */
    AppUpdater setUpdateXML(@NonNull String xmlUrl);

    /**
     * Set the url to the json file with the latest version info.
     *
     * @param jsonUrl file
     * @return this
     */

    AppUpdater setUpdateJSON(@NonNull String jsonUrl);

    /**
     * Set the times the app ascertains that a new update is available and display a dialog, Snackbar or notification. It makes the updates less invasive. Default: 1.
     *
     * @param times every X times
     * @return this
     */
    AppUpdater showEvery(Integer times);

    /**
     * Set if the dialog, Snackbar or notification is displayed although there aren't updates. Default: false.
     *
     * @param res true to show, false otherwise
     * @return this
     */
    AppUpdater showAppUpdated(Boolean res);

    /**
     * Set a custom title for the dialog when an update is available.
     *
     * @param title for the dialog
     * @return this
     * @deprecated use {@link #setTitleOnUpdateAvailable(String)} instead
     */
    AppUpdater setDialogTitleWhenUpdateAvailable(@NonNull String title);

    /**
     * Set a custom title for the dialog when an update is available.
     *
     * @param textResource resource from the strings xml file for the dialog
     * @return this
     * @deprecated use {@link #setTitleOnUpdateAvailable(int)} instead
     */
    AppUpdater setDialogTitleWhenUpdateAvailable(@StringRes int textResource);

    /**
     * Set a custom title for the dialog when an update is available.
     *
     * @param title for the dialog
     * @return this
     */
    AppUpdater setTitleOnUpdateAvailable(@NonNull String title);

    /**
     * Set a custom title for the dialog when an update is available.
     *
     * @param textResource resource from the strings xml file for the dialog
     * @return this
     */
    AppUpdater setTitleOnUpdateAvailable(@StringRes int textResource);

    /**
     * Set a custom description for the dialog when an update is available.
     *
     * @param description for the dialog
     * @return this
     * @deprecated use {@link #setContentOnUpdateAvailable(String)} instead
     */
    AppUpdater setDialogDescriptionWhenUpdateAvailable(@NonNull String description);

    /**
     * Set a custom description for the dialog when an update is available.
     *
     * @param textResource resource from the strings xml file for the dialog
     * @return this
     * @deprecated use {@link #setContentOnUpdateAvailable(int)} instead
     */
    AppUpdater setDialogDescriptionWhenUpdateAvailable(@StringRes int textResource);

    /**
     * Set a custom description for the dialog when an update is available.
     *
     * @param description for the dialog
     * @return this
     */
    AppUpdater setContentOnUpdateAvailable(@NonNull String description);

    /**
     * Set a custom description for the dialog when an update is available.
     *
     * @param textResource resource from the strings xml file for the dialog
     * @return this
     */
    AppUpdater setContentOnUpdateAvailable(@StringRes int textResource);

    /**
     * Set a custom title for the dialog when no update is available.
     *
     * @param title for the dialog
     * @return this
     * @deprecated use {@link #setTitleOnUpdateNotAvailable(String)} instead
     */
    AppUpdater setDialogTitleWhenUpdateNotAvailable(@NonNull String title);

    /**
     * Set a custom title for the dialog when no update is available.
     *
     * @param textResource resource from the strings xml file for the dialog
     * @return this
     * @deprecated use {@link #setTitleOnUpdateNotAvailable(int)} instead
     */
    AppUpdater setDialogTitleWhenUpdateNotAvailable(@StringRes int textResource);

    /**
     * Set a custom title for the dialog when no update is available.
     *
     * @param title for the dialog
     * @return this
     */
    AppUpdater setTitleOnUpdateNotAvailable(@NonNull String title);

    /**
     * Set a custom title for the dialog when no update is available.
     *
     * @param textResource resource from the strings xml file for the dialog
     * @return this
     */
    AppUpdater setTitleOnUpdateNotAvailable(@StringRes int textResource);

    /**
     * Set a custom description for the dialog when no update is available.
     *
     * @param description for the dialog
     * @return this
     * @deprecated use {@link #setContentOnUpdateNotAvailable(String)} instead
     */
    AppUpdater setDialogDescriptionWhenUpdateNotAvailable(@NonNull String description);

    /**
     * Set a custom description for the dialog when no update is available.
     *
     * @param textResource resource from the strings xml file for the dialog
     * @return this
     * @deprecated use {@link #setContentOnUpdateNotAvailable(int)} instead
     */
    AppUpdater setDialogDescriptionWhenUpdateNotAvailable(@StringRes int textResource);

    /**
     * Set a custom description for the dialog when no update is available.
     *
     * @param description for the dialog
     * @return this
     */
    AppUpdater setContentOnUpdateNotAvailable(@NonNull String description);

    /**
     * Set a custom description for the dialog when no update is available.
     *
     * @param textResource resource from the strings xml file for the dialog
     * @return this
     */
    AppUpdater setContentOnUpdateNotAvailable(@StringRes int textResource);

    /**
     * Set a custom "Update" button text when a new update is available.
     *
     * @param text for the update button
     * @return this
     * @deprecated use {@link #setButtonUpdate(String)} instead
     */
    AppUpdater setDialogButtonUpdate(@NonNull String text);

    /**
     * Set a custom "Update" button text when a new update is available.
     *
     * @param textResource resource from the strings xml file for the update button
     * @return this
     * @deprecated use {@link #setButtonUpdate(int)} instead
     */
    AppUpdater setDialogButtonUpdate(@StringRes int textResource);

    /**
     * Set a custom "Update" button text when a new update is available.
     *
     * @param text for the update button
     * @return this
     */
    AppUpdater setButtonUpdate(@NonNull String text);

    /**
     * Set a custom "Update" button text when a new update is available.
     *
     * @param textResource resource from the strings xml file for the update button
     * @return this
     */
    AppUpdater setButtonUpdate(@StringRes int textResource);

    /**
     * Set a custom "Dismiss" button text when a new update is available.
     *
     * @param text for the dismiss button
     * @return this
     * @deprecated use {@link #setButtonDismiss(String)} instead
     */
    AppUpdater setDialogButtonDismiss(@NonNull String text);

    /**
     * Set a custom "Dismiss" button text when a new update is available.
     *
     * @param textResource resource from the strings xml file for the dismiss button
     * @return this
     * @deprecated  use {@link #setButtonDismiss(int)} instead
     */
    AppUpdater setDialogButtonDismiss(@StringRes int textResource);

    /**
     * Set a custom "Dismiss" button text when a new update is available.
     *
     * @param text for the dismiss button
     * @return this
     */
    AppUpdater setButtonDismiss(@NonNull String text);

    /**
     * Set a custom "Dismiss" button text when a new update is available.
     *
     * @param textResource resource from the strings xml file for the dismiss button
     * @return this
     */
    AppUpdater setButtonDismiss(@StringRes int textResource);

    /**
     * Set a custom "Don't show again" button text when a new update is available.
     *
     * @param text for the disable button
     * @return this
     * @deprecated use {@link #setButtonDoNotShowAgain(String)} instead
     */
    AppUpdater setDialogButtonDoNotShowAgain(@NonNull String text);

    /**
     * Set a custom "Don't show again" button text when a new update is available.
     *
     * @param textResource resource from the strings xml file for the disable button
     * @return this
     * @deprecated use {@link #setButtonDoNotShowAgain(int)} instead
     */
    AppUpdater setDialogButtonDoNotShowAgain(@StringRes int textResource);

    /**
     * Set a custom "Don't show again" button text when a new update is available.
     *
     * @param text for the disable button
     * @return this
     */
    AppUpdater setButtonDoNotShowAgain(@NonNull String text);

    /**
     * Set a custom "Don't show again" button text when a new update is available.
     *
     * @param textResource resource from the strings xml file for the disable button
     * @return this
     */
    AppUpdater setButtonDoNotShowAgain(@StringRes int textResource);


    AppUpdater setButtonUpdateClickListener(DialogInterface.OnClickListener clickListener);

    /**
     * Sets a custom click listener for the "Dismiss" button when a new update is available.
     *
     * @param clickListener for dismiss button
     * @return this
     */
    AppUpdater setButtonDismissClickListener(DialogInterface.OnClickListener clickListener);


    AppUpdater setButtonDoNotShowAgainClickListener(DialogInterface.OnClickListener clickListener);

    /**
     * Sets the resource identifier for the small notification icon
     *
     * @param iconRes The id of the drawable item
     * @return this
     */
    AppUpdater setIcon(@DrawableRes int iconRes);

    /**
     * Make update dialog non-cancelable, and
     * force user to make update
     *  @param isCancelable true to force user to make update, false otherwise
     *  @return this
     */
    AppUpdater setCancelable(Boolean isCancelable);

    /**
     * Execute AppUpdater in background.
     *
     * @return this
     * @deprecated use {@link #start()} instead
     */
    AppUpdater init();

    /**
     * Execute AppUpdater in background.
     */
    void start();

    /**
     * Stops the execution of AppUpdater.
     */
    void stop();

    /**
     * Dismisses the alert dialog or the snackbar.
     */
    void dismiss();

    interface LibraryListener {
        void onSuccess(Update update);

        void onFailed(AppUpdaterError error);
    }
}

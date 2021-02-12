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
import android.content.DialogInterface;

/**
 * Click listener for the "Do Not Show Again" button of the update dialog. <br/>
 * Extend this class to add custom actions to the button on top of the default functionality.
 */
public class DisableClickListener implements DialogInterface.OnClickListener {

    private final LibraryPreferences libraryPreferences;

    public DisableClickListener(final Context context) {
        libraryPreferences = new LibraryPreferences(context);
    }

    @Override
    public void onClick(final DialogInterface dialog, final int which) {
        libraryPreferences.setAppUpdaterShow(false);
    }
}

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


import com.vimal.helpers.appupdate.enums.UpdateFrom;

import java.net.URL;

/**
 * Click listener for the "Update" button of the update dialog. <br/>
 * Extend this class to add custom actions to the button on top of the default functionality.
 */
public class UpdateClickListener implements DialogInterface.OnClickListener {

    private final Context context;
    private final UpdateFrom updateFrom;
    private final URL apk;

    public UpdateClickListener(final Context context, final UpdateFrom updateFrom, final URL apk) {
        this.context = context;
        this.updateFrom = updateFrom;
        this.apk = apk;
    }

    @Override
    public void onClick(final DialogInterface dialog, final int which) {
        UtilsLibrary.goToUpdate(context, updateFrom, apk);
    }
}

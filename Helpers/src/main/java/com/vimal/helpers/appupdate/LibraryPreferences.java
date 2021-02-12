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
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

class LibraryPreferences {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    static final String KeyAppUpdaterShow = "prefAppUpdaterShow";
    static final String KeySuccessfulChecks = "prefSuccessfulChecks";

    public LibraryPreferences(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.editor = sharedPreferences.edit();
    }

    public Boolean getAppUpdaterShow() {
        return sharedPreferences.getBoolean(KeyAppUpdaterShow, true);
    }

    public void setAppUpdaterShow(Boolean res) {
        editor.putBoolean(KeyAppUpdaterShow, res);
        editor.commit();
    }

    public Integer getSuccessfulChecks() {
        return sharedPreferences.getInt(KeySuccessfulChecks, 0);
    }

    public void setSuccessfulChecks(Integer checks) {
        editor.putInt(KeySuccessfulChecks, checks);
        editor.commit();
    }

}

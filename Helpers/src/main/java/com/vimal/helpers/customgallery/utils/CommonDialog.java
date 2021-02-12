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
package com.vimal.helpers.customgallery.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;


public class CommonDialog {
    public static void showDialogConfirm(Activity activity, int message, String yesText, String noText, OnClickListener onYes, OnClickListener onNo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.setPositiveButton((CharSequence) yesText, onYes);
        builder.setNegativeButton((CharSequence) noText, onNo);
        builder.create().show();
    }

    public static void showInfoDialog(Activity activity, int message, String yesText, OnClickListener onYes) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.setPositiveButton((CharSequence) yesText, onYes);
        builder.create().show();
    }
}

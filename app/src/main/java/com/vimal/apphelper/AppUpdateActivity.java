package com.vimal.apphelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.vimal.helpers.appupdate.AppUpdater;
import com.vimal.helpers.appupdate.enums.Display;
import com.vimal.helpers.appupdate.enums.UpdateFrom;

public class AppUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_update);



//         showAppUpdated(true)   //always show app is updated dialog
//        showAppUpdated(false)  //always dismiss app is updated dialog

        findViewById(R.id.dialog_no_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppUpdater(AppUpdateActivity.this)
                        .setUpdateFrom(UpdateFrom.GOOGLE_PLAY)
                        .setDisplay(Display.DIALOG)
                        .showAppUpdated(true)
                        .start();
            }
        });

        findViewById(R.id.snackbar_no_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppUpdater(AppUpdateActivity.this)
                        .setUpdateFrom(UpdateFrom.GOOGLE_PLAY)
                        .setDisplay(Display.SNACKBAR)
                        .showAppUpdated(true)
                        .start();
            }
        });

        findViewById(R.id.notification_no_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppUpdater(AppUpdateActivity.this)
                        .setUpdateFrom(UpdateFrom.GOOGLE_PLAY)
                        .setDisplay(Display.NOTIFICATION)
                        .showAppUpdated(true)
                        .start();
            }
        });
        findViewById(R.id.checkappupdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppUpdater(AppUpdateActivity.this)
                        .setTitleOnUpdateAvailable("Your Title.")
                        .setContentOnUpdateAvailable("Content")
                        .setUpdateFrom(UpdateFrom.GOOGLE_PLAY)
                        .setDisplay(Display.DIALOG)
                        .setButtonDoNotShowAgain("Don't Show")
                        .showAppUpdated(true)
                        .start();
            }
        });
    }
}
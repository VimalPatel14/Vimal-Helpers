package com.vimal.apphelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.vimal.apphelper.Image.ImageviewActivity;
import com.vimal.apphelper.video.VideoActivity;
import com.vimal.helpers.customgallery.activity.PickImageActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> pathList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.appupdate).setOnClickListener(this);
        findViewById(R.id.customgallery).setOnClickListener(this);
        findViewById(R.id.imageview).setOnClickListener(this);
        findViewById(R.id.video).setOnClickListener(this);
        findViewById(R.id.permission).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appupdate:
                startActivity(new Intent(MainActivity.this, AppUpdateActivity.class));
                break;
            case R.id.customgallery:
                Intent mIntent = new Intent(MainActivity.this, PickImageActivity.class);
                mIntent.putExtra(PickImageActivity.KEY_LIMIT_MAX_IMAGE, 60);
                mIntent.putExtra(PickImageActivity.KEY_LIMIT_MIN_IMAGE, 3);
                startActivityForResult(mIntent, PickImageActivity.PICKER_REQUEST_CODE);
                break;
            case R.id.imageview:
                startActivity(new Intent(MainActivity.this, ImageviewActivity.class));
                break;
            case R.id.video:
                startActivity(new Intent(MainActivity.this, VideoActivity.class));
                break;
            case R.id.permission:

                break;

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != RESULT_OK) {
            return;
        }
        if (resultCode == -1 && requestCode == PickImageActivity.PICKER_REQUEST_CODE) {
            this.pathList = intent.getExtras().getStringArrayList(PickImageActivity.KEY_DATA_RESULT);
            if (this.pathList != null && !this.pathList.isEmpty()) {
                StringBuilder sb=new StringBuilder("");
                for(int i=0;i<pathList.size();i++) {
                    sb.append("Photo"+(i+1)+":"+pathList.get(i));
                    sb.append("\n");
                }
                Toast.makeText(MainActivity.this,pathList.size()+" Image Selected",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

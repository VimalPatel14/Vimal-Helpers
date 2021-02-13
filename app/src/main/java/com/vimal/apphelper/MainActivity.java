package com.vimal.apphelper;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tedpark.tedpermission.rx2.TedRx2Permission;
import com.vimal.apphelper.Image.CircleImageviewActivity;
import com.vimal.apphelper.Image.ImageviewActivity;
import com.vimal.apphelper.video.VideoActivity;
import com.vimal.helpers.ToastVimal;
import com.vimal.helpers.customgallery.activity.PickImageActivity;
import com.vimal.helpers.download.DownloadListener;
import com.vimal.helpers.download.DownloadUtil;
import com.vimal.helpers.download.InputParameter;
import com.vimal.helpers.helpers.FileHelpers;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> pathList;
//    File imageDir = new File(Environment.getExternalStorageDirectory() + File.separator + Helpers.Main_Folder_Name);
//    String dir = imageDir + File.separator + Helpers.Ringtone_Folder_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.appupdate).setOnClickListener(this);
        findViewById(R.id.customgallery).setOnClickListener(this);
        findViewById(R.id.imageview).setOnClickListener(this);
        findViewById(R.id.circleimageview).setOnClickListener(this);
        findViewById(R.id.video).setOnClickListener(this);
        findViewById(R.id.download).setOnClickListener(this);


//        ToastVimal.showToastMessage(MainActivity.this,"Hello");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appupdate:
                startActivity(new Intent(MainActivity.this, AppUpdateActivity.class));
                break;
            case R.id.customgallery:

                TedRx2Permission.with(MainActivity.this)
                        .setRationaleTitle(R.string.read_storage)
                        .setRationaleMessage(R.string.storage_message)
                        .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .request()
                        .subscribe(permissionResult -> {
                                    if (permissionResult.isGranted()) {
                                        Intent mIntent = new Intent(MainActivity.this, PickImageActivity.class);
                                        mIntent.putExtra(PickImageActivity.KEY_LIMIT_MAX_IMAGE, 60);
                                        mIntent.putExtra(PickImageActivity.KEY_LIMIT_MIN_IMAGE, 3);
                                        startActivityForResult(mIntent, PickImageActivity.PICKER_REQUEST_CODE);
                                    } else {
                                        Toast.makeText(getBaseContext(), "Permission Denied\n" + permissionResult.getDeniedPermissions().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                        );


                break;
            case R.id.imageview:
                startActivity(new Intent(MainActivity.this, ImageviewActivity.class));
                break;
            case R.id.circleimageview:
                startActivity(new Intent(MainActivity.this, CircleImageviewActivity.class));
                break;
            case R.id.video:
                startActivity(new Intent(MainActivity.this, VideoActivity.class));
                break;
            case R.id.download:
                FileHelpers.CreateFolder("vilspatel");
                String base = "yourbaseurl";
                String url = base + "A20211253588103.mp3";
                String file_name = url.substring(url.lastIndexOf('/'));
                File filechk = FileHelpers.getFile(FileHelpers.getFolderPath("vilspatel"), "yourbaseurl" + "A20211253588103.mp3");
                if (!filechk.exists()) {
                    DownloadUtil.getInstance()
                            .downloadFile(new InputParameter.Builder("yourbaseurl", "A20211253588103.mp3", FileHelpers.getFolderPath("vilspatel") + file_name)
                                    .setCallbackOnUiThread(true)
                                    .build(), new DownloadListener() {
                                @Override
                                public void onFinish(final File file) {
                                    Toast.makeText(MainActivity.this, "Download Finish", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onProgress(int progress, long downloadedLengthKb, long totalLengthKb) {
                                    Toast.makeText(MainActivity.this, "Progress " + progress, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailed(String errMsg) {

                                    Toast.makeText(MainActivity.this, "Download Faild", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(MainActivity.this, "File Already Exists", Toast.LENGTH_SHORT).show();
                }

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
                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < pathList.size(); i++) {
                    sb.append("Photo" + (i + 1) + ":" + pathList.get(i));
                    sb.append("\n");
                }
                Toast.makeText(MainActivity.this, pathList.size() + " Image Selected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

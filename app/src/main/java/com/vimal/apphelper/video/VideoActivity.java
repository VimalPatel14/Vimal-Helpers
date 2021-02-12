package com.vimal.apphelper.video;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.vimal.apphelper.R;
import com.vimal.helpers.videoview.UniversalMediaController;
import com.vimal.helpers.videoview.VideoView;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;
    private UniversalMediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        try {
            mediaController = findViewById(R.id.media_controller);
        } catch (Exception ignored) {
        }

        videoView = findViewById(R.id.video_view);
        videoView.setVideoViewCallback(new VideoView.VideoViewCallback() {
            @Override
            public void onScaleChange(boolean isFullscreen) {

            }

            @Override
            public void onPause(MediaPlayer mediaPlayer) {
                System.out.println("Pause!");

            }

            @Override
            public void onStart(MediaPlayer mediaPlayer) {
                System.out.println("Play!");

            }

            @Override
            public void onBufferingStart(MediaPlayer mediaPlayer) {

            }

            @Override
            public void onBufferingEnd(MediaPlayer mediaPlayer) {

            }
        });

        String path = "android.resource://" + getPackageName() + "/" + "R.raw.video";
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
        videoView.setOnPreparedListener(mp -> mp.setLooping(true));
        if (mediaController != null) videoView.setMediaController(mediaController);

    }
}
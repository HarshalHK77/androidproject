package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;

public class AsyncTask extends AppCompatActivity {

    private Button btnPlayAudio, btnStopAudio;
    private Button btnPlayVideo, btnStopVideo;
    private VideoView videoView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        btnPlayAudio = findViewById(R.id.btnPlayAudio);
        btnStopAudio = findViewById(R.id.btnStopAudio);
        btnPlayVideo = findViewById(R.id.btnPlayVideo);
        btnStopVideo = findViewById(R.id.btnStopVideo);
        videoView = findViewById(R.id.videoView);

        btnPlayAudio.setOnClickListener(view -> playAudio());
        btnStopAudio.setOnClickListener(view -> stopAudio());
        btnPlayVideo.setOnClickListener(view -> playVideo());
        btnStopVideo.setOnClickListener(view -> stopVideo());
    }

    private void playAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        mediaPlayer.start();
    }

    private void stopAudio() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void playVideo() {
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(MediaPlayer::start);
        videoView.requestFocus();
    }

    private void stopVideo() {
        if (videoView.isPlaying()) {
            videoView.stopPlayback();
            videoView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (videoView != null) {
            videoView.suspend();
        }
    }
}


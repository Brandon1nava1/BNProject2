package com.example.artistapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BiographyActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private int currentSongResId = -1;

    private Button btDoubt, btFirstDate;

    //Changing the Button Text when playing A song or stopping it
    private void toggleMusic(int resId, Button clickedButton, Button otherButton, String clickedLabel, String otherLabel) {
        if (mediaPlayer != null && currentSongResId == resId) {

            //Toggling the song (pause/resume)
            if (isPlaying) {
                mediaPlayer.pause();
                isPlaying = false;
                clickedButton.setText("Resume " + clickedLabel);
            } else {
                mediaPlayer.start();
                isPlaying = true;
                clickedButton.setText("Pause " + clickedLabel);
            }
        } else {
            //Stopping previous song, Playing new song logic
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            mediaPlayer = mediaPlayer.create(this, resId);
            mediaPlayer.setLooping(false);

            //Set volume to maximum (left and right channels)
            mediaPlayer.setVolume(1.0f, 1.0f);

            mediaPlayer.start();
            isPlaying = true;
            currentSongResId = resId;

            //Set button Labels
            clickedButton.setText("Pause " + clickedLabel);
            otherButton.setText(otherLabel);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_biography);

        //Return button to Main Activity
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(v -> finish());

        //Button to go to about us screen
        Button btAbout = findViewById(R.id.btAbout);
        btAbout.setOnClickListener(v -> {
                    Intent intent = new Intent(BiographyActivity.this, AboutUsActivity.class);
                    startActivity(intent);
                });

        //Setting up the Music Buttons
        btDoubt = findViewById(R.id.btDoubt);
        btFirstDate = findViewById(R.id.btFirstDate);

        btDoubt.setOnClickListener(v ->
                toggleMusic(R.raw.thedoubt, btDoubt, btFirstDate,
                        "The Doubt", "The First Date"));

        btFirstDate.setOnClickListener(v ->
                toggleMusic(R.raw.thefirstdate, btFirstDate, btDoubt,
                        "The First Date", "The Doubt"));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    if (mediaPlayer != null) {
        mediaPlayer.release();
        mediaPlayer = null;
    }
    }
}
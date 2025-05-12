package com.example.artistapp;
// Brandon Nava Project 2
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_us);

        //Return button to Biology Activity
        ImageButton btBack2 = findViewById(R.id.btBack2);
        btBack2.setOnClickListener(v -> finish());

        //Facebook button opens App (or web)
        ImageButton facebookButton = findViewById(R.id.btFaceBook);
        facebookButton.setOnClickListener(c -> {
            String facebookUrl = "https://www.facebook.com/Mr.Dougie";
            String facebookAppUri = "fb://facewebmodal/f?href=" + facebookUrl;

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookAppUri));

            //Try opening FB App, If App not installed open in browser
            try {
                startActivity(intent);
            } catch (Exception e) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));
                startActivity(browserIntent);
            }
        });

        //Instagram button opens App (or web)
        ImageButton instagramButton = findViewById(R.id.btInsta);
        instagramButton.setOnClickListener(c -> {
            String instagramUrl = "https://www.instagram.com/themantrahouse614/";
            String instagramAppUri = "instagram://user?username=themantrahouse614";

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramAppUri));

            //Try opening Insta App, If App not installed open in browser
            try {
                startActivity(intent);
            } catch (Exception e) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));
                startActivity(browserIntent);
            }
        });

        //YouTube button opens App (or web)
        ImageButton youtubeButton = findViewById(R.id.btYoutube);
        youtubeButton.setOnClickListener(c -> {
            String youtubeUrl = "https://www.youtube.com/channel/UC9jHOu6jD0fRq_eqjgmvLxg";
            String youtubeAppUri = "vnd.youtube://channel/UC9jHOu6jD0fRq_eqjgmvLxg";

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeAppUri));

            //Try opening YouTube App, If App not installed open in browser
            try {
                startActivity(intent);
            } catch (Exception e) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl));
                startActivity(browserIntent);
            }
        });

        //Website button opens browser
        ImageButton websiteButton = findViewById(R.id.btWeb);
        websiteButton.setOnClickListener(c -> {
            String websiteUrl = "https://www.themantrahouse.com/";
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
            startActivity(browserIntent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
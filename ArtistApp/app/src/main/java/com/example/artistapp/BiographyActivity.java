package com.example.artistapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BiographyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_biography);

        //Return button to Main Activity
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(v -> finish());

        //Button to go about us screen
        Button btAbout = findViewById(R.id.btAbout);
        btAbout.setOnClickListener(v -> {
                    Intent intent = new Intent(BiographyActivity.this, AboutUsActivity.class);
                    startActivity(intent);
                });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}
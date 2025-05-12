package com.example.artistapp;
// Brandon Nava Project 2
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Button to Bio Screen
        Button btBio = findViewById(R.id.btBio);
        btBio.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, BiographyActivity.class);
                    startActivity(intent);
                });

        //Button to Lotto Screen
        Button btLotto = findViewById(R.id.btLotto);
        btLotto.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LottoActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
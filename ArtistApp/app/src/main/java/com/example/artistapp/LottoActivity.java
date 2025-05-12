package com.example.artistapp;
// Brandon Nava Project 2
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LottoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lotto);

        ImageButton btBack3 = findViewById(R.id.btBack3);
        Button btResult = findViewById(R.id.btResult);
        EditText tvTickets2 = findViewById(R.id.tvTickets2);

        //Return button to Main Activity
        btBack3.setOnClickListener(v -> finish());

        //Go to probability Results Screen
        btResult.setOnClickListener(v -> {
            String input = tvTickets2.getText().toString().trim();
            if (!input.isEmpty()){
                try {
                    int ticketCount = Integer.parseInt(input);
                    if (ticketCount < 0) {
                        Toast.makeText(this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(LottoActivity.this, Prob_Result_Activity.class);
                        intent.putExtra("ticket_count", ticketCount);
                        startActivity(intent);
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter how many tickets you purchased", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
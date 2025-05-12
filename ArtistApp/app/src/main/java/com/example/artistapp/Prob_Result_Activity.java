package com.example.artistapp;
// Brandon Nava Project 2
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Prob_Result_Activity extends AppCompatActivity {

    private TextView tvAmount, tvPercent;

    private static final double ODDS_OF_WINNING = 1.0 / 292201338.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prob_result);

        // Find views
        tvAmount = findViewById(R.id.tvAmount);
        tvPercent = findViewById(R.id.tvPercent);
        ImageButton btBack4 = findViewById(R.id.btBack4);

        // Get ticket count from intent
        int ticketCount = getIntent().getIntExtra("ticket_count", 0);

        // Calculate results
        int approxNeededTickets = (int) Math.ceil(1 / ODDS_OF_WINNING);
        double winChance = ticketCount * ODDS_OF_WINNING * 100;

        // Display Results
        tvAmount.setText(String.valueOf(approxNeededTickets));
        tvPercent.setText(String.format("%.8f%%", winChance));

        //Back button
        btBack4.setOnClickListener(v -> finish());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
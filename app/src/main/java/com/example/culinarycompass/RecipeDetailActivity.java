package com.example.culinarycompass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Objects;

public class RecipeDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recipe_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar3);
        toolbar.setNavigationOnClickListener(v -> {
            // balik ke HomeActivity
            Intent intent = new Intent(RecipeDetailActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Tutup activity sekarang
        });

        TextView detailTitleTV, detailServingTimeTV, detailServingsTV, detailInstructionsTV, detailSummaryTV;
        ImageView detailImageIV;
        detailTitleTV = findViewById(R.id.detailTitleTV);
        detailServingsTV = findViewById(R.id.detailServingsTV);
        detailInstructionsTV = findViewById(R.id.detailInstructionsTV);
        detailSummaryTV = findViewById(R.id.detailSummaryTV);
        detailImageIV = findViewById(R.id.detailImageIV);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String image = intent.getStringExtra("image");
        String servingTime = intent.getStringExtra("servingTime");
        String servings = intent.getStringExtra("servings");
        ArrayList<String> instructions = intent.getStringArrayListExtra("instructions");
        String summary = intent.getStringExtra("summary");

        detailTitleTV.setText(title);
        detailServingsTV.setText(servings);
        detailSummaryTV.setText("SUMMARY: "+ summary);
        detailServingsTV.setText(servingTime);
        Glide.with(this)
                .load(image) // The URL of the image
                 // Optional: An error image if the URL fails
                .into(detailImageIV);
        if (instructions != null) {
            StringBuilder instructionText = new StringBuilder();
            for (String step : instructions) {
                instructionText.append(step).append("\n\n");
            }
            detailInstructionsTV.setText("INSTRUCTIONS: " + instructionText.toString().trim());
        }

    }

}
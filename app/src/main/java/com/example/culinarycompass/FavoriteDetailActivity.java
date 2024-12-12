package com.example.culinarycompass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class FavoriteDetailActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_detail);

        Toolbar toolbar = findViewById(R.id.toolbar3);
        toolbar.setNavigationOnClickListener(v -> finish()); // Close activity

        // Initialize Firebase
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        // UI components
        TextView favTitleTV, favServingTimeTV, favServingsTV, favInstructionsTV, favSummaryTV;
        ImageView favImageIV;
        Button favDeleteBtn;

        favTitleTV = findViewById(R.id.favTitleTV);
        favServingsTV = findViewById(R.id.favServingsTV);
        favInstructionsTV = findViewById(R.id.favInstructionsTV);
        favSummaryTV = findViewById(R.id.favSummaryTV);
        favServingTimeTV = findViewById(R.id.favServingTimeTV);
        favImageIV = findViewById(R.id.favImageIV);
        favDeleteBtn = findViewById(R.id.favDeleteBtn);

        // Get data from intent
        Intent intent = getIntent();
        String recipeId = intent.getStringExtra("recipeId");
        String title = intent.getStringExtra("title");
        String image = intent.getStringExtra("image");
        String servingTime = intent.getStringExtra("servingTime");
        String servings = intent.getStringExtra("servings");
        ArrayList<String> instructions = intent.getStringArrayListExtra("instructions");
        String summary = intent.getStringExtra("summary");

        // Set data to UI
        favTitleTV.setText(title);
        favServingsTV.setText(servings);
        favSummaryTV.setText("SUMMARY: " + summary);
        favServingTimeTV.setText(servingTime);
        Glide.with(this).load(image).into(favImageIV);

        if (instructions != null) {
            StringBuilder instructionText = new StringBuilder();
            for (String step : instructions) {
                instructionText.append(step).append("\n\n");
            }
            favInstructionsTV.setText("INSTRUCTIONS: " + instructionText.toString().trim());
        }

        // Delete button click listener
        favDeleteBtn.setOnClickListener(v -> deleteFromFavorites(recipeId));
    }

    private void deleteFromFavorites(String recipeId) {

}}
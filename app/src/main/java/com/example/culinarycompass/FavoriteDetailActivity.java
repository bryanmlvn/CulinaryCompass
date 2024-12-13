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
        favDeleteBtn.setOnClickListener(v -> deleteFromFavorites(title));
    }

    private void deleteFromFavorites(String title) {
        // Get the current user's UID
        String userId = mAuth.getCurrentUser() != null ? mAuth.getCurrentUser().getUid() : null;

        if (userId == null) {
            Toast.makeText(this, "User not logged in. Please log in to delete favorites.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Reference to the recipe document in the user's favorites subcollection
        DocumentReference recipeRef = db.collection("users")
                .document(userId)
                .collection("favorites")
                .document(title); // Using title as the document ID

        // Delete the document
        recipeRef.delete()
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Recipe removed from favorites!", Toast.LENGTH_SHORT).show();

                    // Notify the FavoritesFragment to refresh
                    Intent intent = new Intent();
                    intent.setAction("com.example.culinarycompass.REFRESH_FAVORITES");
                    sendBroadcast(intent);

                    finish(); // Optionally, you can finish the activity after deletion
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Failed to remove recipe: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

}
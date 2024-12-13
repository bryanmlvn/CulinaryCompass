package com.example.culinarycompass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecipeDetailActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

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
            finish(); // Tutup activity
        });

        // Initialize Firebase
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        // UI components
        TextView detailTitleTV, detailServingTimeTV, detailServingsTV, detailInstructionsTV, detailSummaryTV;
        ImageView detailImageIV;
        Button detailSaveBtn;

        detailTitleTV = findViewById(R.id.detailTitleTV);
        detailServingsTV = findViewById(R.id.detailServingsTV);
        detailInstructionsTV = findViewById(R.id.detailInstructionsTV);
        detailServingTimeTV = findViewById(R.id.detailServingTimeTV);
        detailSummaryTV = findViewById(R.id.detailSummaryTV);
        detailImageIV = findViewById(R.id.detailImageIV);
        detailSaveBtn = findViewById(R.id.detailSaveBtn);

        // Get data from intent
        Intent intent = getIntent();
        Integer recipeId = intent.getIntExtra("recipeId", -1);
        String title = intent.getStringExtra("title");
        String image = intent.getStringExtra("image");
        String servingTime = intent.getStringExtra("servingTime");
        String servings = intent.getStringExtra("servings");
        ArrayList<String> instructions = intent.getStringArrayListExtra("instructions");
        String summary = intent.getStringExtra("summary");

        // Set data to UI
        detailTitleTV.setText(title);
        detailServingsTV.setText(servings);
        detailServingTimeTV.setText(servingTime);
        detailSummaryTV.setText("SUMMARY: " + summary);
        detailServingsTV.setText(servingTime);
        Glide.with(this).load(image).into(detailImageIV);

        if (instructions != null) {
            StringBuilder instructionText = new StringBuilder();
            for (String step : instructions) {
                instructionText.append(step).append("\n\n");
            }
            detailInstructionsTV.setText("INSTRUCTIONS: " + instructionText.toString().trim());
        }

        // Save button click listener
        detailSaveBtn.setOnClickListener(v -> saveToFavorites(title, image, servings, servingTime, summary, instructions));
    }

    private void saveToFavorites(String title, String image, String servings, String servingTime, String summary, ArrayList<String> instructions) {
        // Get the current user's UID
        String userId = mAuth.getCurrentUser() != null ? mAuth.getCurrentUser().getUid() : null;

        if (userId == null) {
            Toast.makeText(this, "User not logged in. Please log in to save favorites.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Reference to the user's favorites subcollection
        db.collection("users")
                .document(userId)
                .collection("favorites")
                .document(title) // Use the title as the document ID
                .set(createRecipeData(title, image, servings, servingTime, summary, instructions))
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Recipe saved to favorites!", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Failed to save recipe: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private Map<String, Object> createRecipeData(String title, String image, String servings, String servingTime, String summary, ArrayList<String> instructions) {
        Map<String, Object> recipeData = new HashMap<>();
        recipeData.put("title", title);
        recipeData.put("image", image);
        recipeData.put("servings", servings);
        recipeData.put("servingTime", servingTime);
        recipeData.put("summary", summary);
        recipeData.put("instructions", instructions); // Firestore supports lists

        return recipeData;
    }
}
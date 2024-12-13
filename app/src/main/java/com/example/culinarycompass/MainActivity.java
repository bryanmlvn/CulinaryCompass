package com.example.culinarycompass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
//TODO:
//DUPLICATE FAVORITE
//CHANGE PASSWORD
public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Initialize FirebaseAuth and SharedPreferences
        mAuth = FirebaseAuth.getInstance();
        sharedPreferences = getSharedPreferences("CulinaryCompassPrefs", MODE_PRIVATE);

        // Check "Remember Me" and session state
        if (mAuth.getCurrentUser() != null && isRememberMeEnabled() && !isSessionExpired()) {
            // Redirect to HomeActivity if the user is logged in, "Remember Me" is checked, and session is valid
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Close MainActivity
            return; // Prevent further execution of onCreate
        }

        // If no valid session, show the main login and register buttons
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Button references
        Button mainLoginBtn = findViewById(R.id.mainLoginBtn);
        Button mainRegisterBtn = findViewById(R.id.mainRegisterBtn);

        // Login button click
        mainLoginBtn.setOnClickListener(v -> {
            Intent pindahLogin = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(pindahLogin);
        });

        // Register button click
        mainRegisterBtn.setOnClickListener(v -> {
            Intent pindahRegister = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(pindahRegister);
        });
    }

    private boolean isRememberMeEnabled() {
        return sharedPreferences.getBoolean("remember_me", false);
    }

    private boolean isSessionExpired() {
        long loginTime = sharedPreferences.getLong("login_time", 0);
        long currentTime = System.currentTimeMillis();
        return currentTime - loginTime > 24 * 60 * 60 * 1000; // 24 hours in milliseconds
    }
}
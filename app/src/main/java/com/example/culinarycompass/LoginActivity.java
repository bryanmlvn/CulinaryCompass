package com.example.culinarycompass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        sharedPreferences = getSharedPreferences("CulinaryCompassPrefs", MODE_PRIVATE);

        // Check if the session is valid (user is already logged in)
        if (isRememberMeEnabled() && !isSessionExpired()) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Close the LoginActivity
            return;
        }

        // UI References
        Button loginLoginBtn = findViewById(R.id.loginLoginBtn);
        EditText loginNameET = findViewById(R.id.loginNameET);
        EditText loginPasswordET = findViewById(R.id.loginPasswordET);
        CheckBox loginRememberMeCB = findViewById(R.id.loginRememberMeCB);

        // Login button click listener
        loginLoginBtn.setOnClickListener(v -> {
            String email = loginNameET.getText().toString().trim();
            String password = loginPasswordET.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            // Perform login using Firebase Authentication
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(LoginActivity.this, task -> {
                        if (task.isSuccessful()) {
                            // Update "Remember Me" preference
                            saveRememberMePreference(loginRememberMeCB.isChecked());

                            // Redirect to HomeActivity
                            Intent pindahHome = new Intent(LoginActivity.this, HomeActivity.class);
                            pindahHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(pindahHome);
                            finish();
                        } else {
                            // Show error message if login fails
                            Toast.makeText(getApplicationContext(), "Login Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

    // Save the "Remember Me" preference
    private void saveRememberMePreference(boolean isChecked) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("remember_me", isChecked);
        if (isChecked) {
            editor.putLong("login_time", System.currentTimeMillis());
        } else {
            editor.remove("login_time");
        }
        editor.apply();
    }

    // Check if "Remember Me" is enabled
    private boolean isRememberMeEnabled() {
        return sharedPreferences.getBoolean("remember_me", false);
    }

    // Check if session is expired (older than 24 hours)
    private boolean isSessionExpired() {
        long loginTime = sharedPreferences.getLong("login_time", 0);
        long currentTime = System.currentTimeMillis();
        return currentTime - loginTime > 24 * 60 * 60 * 1000; // 24 hours in milliseconds
    }
}
package com.example.culinarycompass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.culinarycompass.MainActivity;
import com.example.culinarycompass.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileFragment extends Fragment {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private TextView profileNameTV, emailNameTV;
    private EditText profileNameEditET;
    private Button profileEditBTN, profileLogoutBTN;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Firebase Auth and Firestore
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize UI components
        profileNameTV = view.findViewById(R.id.profileNameTV);
        emailNameTV = view.findViewById(R.id.profileEmailTV);
        profileNameEditET = view.findViewById(R.id.profileNameEditET);
        profileEditBTN = view.findViewById(R.id.profileEditBTN);
        profileLogoutBTN = view.findViewById(R.id.profileLogoutBTN);

        // Fetch and display the user's name and email
        fetchAndDisplayUserInfo();

        profileEditBTN.setOnClickListener(v -> toggleEditMode());
        // Logout button functionality
        profileLogoutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                // Clear the "Remember Me" preference when logging out
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("CulinaryCompassPrefs", getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("remember_me"); // Remove Remember Me preference
                editor.remove("login_time"); // Remove login time to reset session
                editor.apply();

                // Redirect to the MainActivity (Login Activity)
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear the stack so the user can't navigate back to the HomeActivity
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

    private void fetchAndDisplayUserInfo() {
        // Fetch the email of the current user from FirebaseAuth
        String userEmail = mAuth.getCurrentUser().getEmail();

        if (userEmail != null) {
            emailNameTV.setText(userEmail); // Set the email in the TextView
        } else {
            Toast.makeText(getContext(), "Email not found", Toast.LENGTH_SHORT).show();
        }

        // Fetch the user's name from Firestore (already implemented)
        String userId = mAuth.getCurrentUser().getUid();
        db.collection("users")
                .document(userId)
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String name = documentSnapshot.getString("name");
                            String email = mAuth.getCurrentUser().getEmail();
                            profileNameTV.setText(name); // Set the name in the TextView
                            emailNameTV.setText(email);
                        } else {
                            Toast.makeText(getContext(), "User data not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(e ->
                        Toast.makeText(getContext(), "Failed to fetch user data: " + e.getMessage(), Toast.LENGTH_SHORT).show()
                );
    }

    private void toggleEditMode() {
        if (profileNameEditET.getVisibility() == View.GONE) {
            // Enter edit mode
            profileNameEditET.setText(profileNameTV.getText().toString());
            profileNameEditET.setVisibility(View.VISIBLE);
            profileEditBTN.setText("SAVE");
        } else {
            // Save changes
            String newName = profileNameEditET.getText().toString().trim();
            if (newName.isEmpty()) {
                Toast.makeText(getContext(), "Name cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            updateUserName(newName);
        }
    }

    private void updateUserName(String newName) {
        String userId = mAuth.getCurrentUser().getUid();

        db.collection("users")
                .document(userId)
                .update("name", newName)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(getContext(), "Name updated successfully", Toast.LENGTH_SHORT).show();
                    profileNameTV.setText(newName);
                    profileNameEditET.setVisibility(View.GONE);
                    profileEditBTN.setText("EDIT PROFILE");
                })
                .addOnFailureListener(e -> Toast.makeText(getContext(), "Failed to update name: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}
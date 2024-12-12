package com.example.culinarycompass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.culinarycompass.recyclerview.RecipeAdapter;
import com.example.culinarycompass.recyclerview.RecipeData;
import com.example.culinarycompass.recyclerview.RecyclerViewInterface;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment implements RecyclerViewInterface {

    private RecyclerView favoritesRecipeRV;
    private Context context;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private RecipeAdapter adapter;
    private List<RecipeData> favoriteList = new ArrayList<>();

    public FavoritesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        // Initialize Firebase
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        // Initialize RecyclerView
        favoritesRecipeRV = view.findViewById(R.id.favoritesRecipeRV);
        context = getContext();
        adapter = new RecipeAdapter(favoriteList, context, this);
        favoritesRecipeRV.setLayoutManager(new LinearLayoutManager(context));
        favoritesRecipeRV.setAdapter(adapter);

        // Fetch favorite recipes
        fetchFavorites();

        return view;
    }

    private void fetchFavorites() {
        String userId = mAuth.getCurrentUser().getUid();
        CollectionReference favoritesRef = db.collection("users").document(userId).collection("favorites");

        favoritesRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot querySnapshot = task.getResult();
                if (querySnapshot != null && !querySnapshot.isEmpty()) {
                    for (DocumentSnapshot document : querySnapshot) {
                        RecipeData recipe = document.toObject(RecipeData.class);
                        favoriteList.add(recipe);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "No favorites found", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "Failed to fetch favorites", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent pindahDetail = new Intent(context, FavoriteDetailActivity.class);

        // Pass data to RecipeDetailActivity
        RecipeData recipe = favoriteList.get(position);
        String recipeId = String.valueOf(recipe.getId());
        pindahDetail.putExtra("recipeId", recipeId);
        pindahDetail.putExtra("title", recipe.getTitle());
        pindahDetail.putExtra("image", recipe.getImage());
        pindahDetail.putExtra("servingTime", recipe.getServingTime());
        pindahDetail.putExtra("servings", recipe.getServingJumlah());
        pindahDetail.putExtra("instructions", new ArrayList<>(recipe.getInstructions())); // Pass list as ArrayList
        pindahDetail.putExtra("summary", recipe.getSummary());
        startActivity(pindahDetail);
    }
}
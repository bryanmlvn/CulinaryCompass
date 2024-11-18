package com.example.culinarycompass;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.culinarycompass.recyclerview.RecipeAdapter;
import com.example.culinarycompass.recyclerview.RecipeData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView homeRecipeRV;
    private Context context;
    private RequestQueue requestQueue;
    private List<RecipeData> recipeList = new ArrayList<>();
    private RecipeAdapter adapter;
    private int currentPage = 0; // Tracks the current page
    private final int ITEMS_PER_PAGE = 20; // Number of items per API call
    private boolean isLoading = false; // To prevent multiple simultaneous requests

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize RecyclerView and Adapter
        homeRecipeRV = view.findViewById(R.id.homeRecipeRV);
        context = getContext();
        requestQueue = Volley.newRequestQueue(context);

        adapter = new RecipeAdapter(recipeList, context);
        homeRecipeRV.setLayoutManager(new LinearLayoutManager(context));
        homeRecipeRV.setAdapter(adapter);

        // Load initial data
        requestJsonData(currentPage);

        // Add scroll listener for infinite scrolling
        homeRecipeRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (layoutManager != null && layoutManager.findLastVisibleItemPosition() == recipeList.size() - 1 && !isLoading) {
                    // Load the next page
                    currentPage++;
                    requestJsonData(currentPage);
                }
            }
        });

        return view;
    }

    private void requestJsonData(int page) {
        if (isLoading) return; // Prevent duplicate calls
        isLoading = true;

        String API_KEY = "4d3a025bf302462a8c5295ccb06c36c5";
        String URL = "https://api.spoonacular.com/recipes/random?number=" + ITEMS_PER_PAGE + "&apiKey=" + API_KEY;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("recipes");
                            fetchTheData(jsonArray);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Data Parsing Error", Toast.LENGTH_SHORT).show();
                        } finally {
                            isLoading = false;
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "API Request Failed", Toast.LENGTH_SHORT).show();
                        isLoading = false;
                    }
                });

        requestQueue.add(stringRequest);
    }

    private void fetchTheData(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject recipe = jsonArray.getJSONObject(i);
                recipeList.add(new RecipeData(
                        recipe.getInt("id"),
                        recipe.getString("image"),
                        recipe.getString("title"),
                        recipe.getString("summary"),
                        recipe.getString("readyInMinutes"),
                        recipe.getString("servings")
                ));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        adapter.notifyDataSetChanged();
    }
}
package com.example.culinarycompass.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.culinarycompass.R;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeAdapterHolder> {
    private List<RecipeData> recipeList;
    private Context context;
    private final RecyclerViewInterface recyclerViewInterface;


    public RecipeAdapter(List<RecipeData> recipeList, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.recipeList = recipeList;
        this.context = context;
        this.recyclerViewInterface =recyclerViewInterface;
    }

    @NonNull
    @Override
    public RecipeAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recipe_item, parent, false);
        return new RecipeAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapterHolder holder, int position) {
        holder.itemTitleTV.setText(recipeList.get(position).getTitle());
        holder.itemSummaryTV.setText(recipeList.get(position).getSummary());
        holder.itemServingsTV.setText(recipeList.get(position).getServingJumlah());
        holder.itemServingTimeTV.setText(recipeList.get(position).getServingTime());
        Glide.with(holder.itemView.getContext())
                .load(recipeList.get(position).getImage()) // Pass the image URL here
                .into(holder.itemImageIV);

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class RecipeAdapterHolder extends RecyclerView.ViewHolder{
        private TextView itemTitleTV, itemSummaryTV, itemServingTimeTV, itemServingsTV;
        private ImageView itemImageIV;
        public RecipeAdapterHolder(@NonNull View itemView) {
            super(itemView);
            itemTitleTV = itemView.findViewById(R.id.itemTitleTV);
            itemSummaryTV = itemView.findViewById(R.id.itemSummaryTV);
            itemServingTimeTV = itemView.findViewById(R.id.itemServingTimeTV);
            itemServingsTV = itemView.findViewById(R.id.itemServingsTV);
            itemImageIV = itemView.findViewById(R.id.itemImageIV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}

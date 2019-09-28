package com.fikri.moviecatalogue3.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fikri.moviecatalogue3.DetailMovieActivity;
import com.fikri.moviecatalogue3.R;
import com.fikri.moviecatalogue3.entity.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.GridViewHolder> {
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieAdapter() {
    }

    private ArrayList<Movie> getMovies() {
        return movies;
    }

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setData(ArrayList<Movie> items) {
        movies.clear();
        movies.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_movie, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.GridViewHolder gridViewHolder, int i) {
        String poster_path = "https://image.tmdb.org/t/p/w185" + movies.get(i).getPoster();
        Glide.with(gridViewHolder.itemView.getContext())
                .load(poster_path)
                .apply(new RequestOptions().override(350, 550))
                .into(gridViewHolder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPoster;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_movie_poster);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Movie movie = getMovies().get(getAdapterPosition());
            Intent moveWithObjectIntent = new Intent(itemView.getContext(), DetailMovieActivity.class);
            moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
            v.getContext().startActivity(moveWithObjectIntent);
        }
    }
}

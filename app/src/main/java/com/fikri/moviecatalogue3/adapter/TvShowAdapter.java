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
import com.fikri.moviecatalogue3.DetailTvShowActivity;
import com.fikri.moviecatalogue3.R;
import com.fikri.moviecatalogue3.entity.TvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.GridViewHolder> {
    private ArrayList<TvShow> tvShows = new ArrayList<>();

    public TvShowAdapter() {
    }

    private ArrayList<TvShow> getTvShows() {
        return tvShows;
    }

    public TvShowAdapter(ArrayList<TvShow> tvShows) {
        this.tvShows = tvShows;
    }

    public void setData(ArrayList<TvShow> items) {
        tvShows.clear();
        tvShows.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TvShowAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_tv_show, viewGroup, false);
        return new TvShowAdapter.GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.GridViewHolder gridViewHolder, int i) {

        String poster_path = "https://image.tmdb.org/t/p/w185" + tvShows.get(i).getPoster();
        Glide.with(gridViewHolder.itemView.getContext())
                .load(poster_path)
                .apply(new RequestOptions().override(350, 550))
                .into(gridViewHolder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPoster;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_tv_show_poster);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            TvShow movie = getTvShows().get(getAdapterPosition());
            Intent moveWithObjectIntent = new Intent(itemView.getContext(), DetailTvShowActivity.class);
            moveWithObjectIntent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, movie);
            v.getContext().startActivity(moveWithObjectIntent);
        }
    }
}

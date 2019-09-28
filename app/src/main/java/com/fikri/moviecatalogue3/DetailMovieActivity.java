package com.fikri.moviecatalogue3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fikri.moviecatalogue3.entity.Movie;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE="extra_movie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        TextView tvTitle = findViewById(R.id.tv_detail_movie_title);
        TextView tvLanguage = findViewById(R.id.tv_detail_movie_language);
        TextView tvVote = findViewById(R.id.tv_detail_movie_vote);
        TextView tvOverview = findViewById(R.id.tv_detail_movie_overview);
        ImageView imgPoster = findViewById(R.id.img_poster_detail_movie);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvTitle.setText(movie.getTitle());
        tvLanguage.setText(movie.getLanguage());
        tvVote.setText(movie.getVote_average().toString());
        tvOverview.setText(movie.getOverview());
        String poster_path = "https://image.tmdb.org/t/p/w185" + movie.getPoster();
        Glide.with(this)
                .load(poster_path)
                .apply(new RequestOptions().override(650, 850))
                .into(imgPoster);

    }
}

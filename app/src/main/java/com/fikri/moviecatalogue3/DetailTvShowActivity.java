package com.fikri.moviecatalogue3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fikri.moviecatalogue3.entity.TvShow;

public class DetailTvShowActivity extends AppCompatActivity {

    public static final String EXTRA_TV_SHOW="extra_tv_show";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        ImageView imgPoster = findViewById(R.id.img_tv_show_poster);
        TextView tvTitle = findViewById(R.id.tv_tv_show_title);
        TextView tvLanguage = findViewById(R.id.tv_tv_show_language);
        TextView tvVote = findViewById(R.id.tv_tv_show_vote);
        TextView tvOverview = findViewById(R.id.tv_tv_show_overview);

        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);

        tvTitle.setText(tvShow.getTitle());
        tvLanguage.setText(tvShow.getLanguage());
        tvVote.setText(tvShow.getVote_average().toString());
        tvOverview.setText(tvShow.getOverview());
        String poster_path = "https://image.tmdb.org/t/p/w185" + tvShow.getPoster();
        Glide.with(this)
                .load(poster_path)
                .apply(new RequestOptions().override(650, 850))
                .into(imgPoster);
    }
}

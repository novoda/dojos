package com.tobi.movies.popularstream;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tobi.movies.MovieApplication;
import com.tobi.movies.R;
import com.tobi.movies.misc.AbstractObserver;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PopularMoviesActivity extends AppCompatActivity {

    private static final String TAG = PopularMoviesActivity.class.getSimpleName();
    private static final int POSTER_COL_COUNT = 3;

    @Bind(R.id.popularMovies_recycler)
    RecyclerView popularMoviesRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_movies);
        ButterKnife.bind(this);

        popularMoviesRecycler.setLayoutManager(new GridLayoutManager(this, POSTER_COL_COUNT));
        popularMoviesRecycler.setHasFixedSize(true);

        final Navigator navigator = new Navigator(this);
        final MovieApplication movieApplication = (MovieApplication) getApplicationContext();
        movieApplication.streamRepository().getPopularPosters().subscribe(new AbstractObserver<List<MoviePoster>>() {

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "Error loading movie posters", e);
            }

            @Override
            public void onNext(List<MoviePoster> moviePosters) {
                popularMoviesRecycler.setAdapter(new MoviePosterAdapter(moviePosters, movieApplication.imageLoader(), navigator));
            }
        });

    }
}

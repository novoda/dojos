package com.tobi.movies.posterdetails;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tobi.movies.ImageLoader;
import com.tobi.movies.MovieApplication;
import com.tobi.movies.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends Activity implements MovieDetailsMVP.View {

    private static final String EXTRA_MOVIE_ID = "extra_movie_id";
    private MovieDetailsUseCase movieDetailsUseCase;

    public static Intent createIntentFor(long movieId, Context activity) {
        Intent intent = new Intent(activity, MovieDetailsActivity.class);
        intent.putExtra(EXTRA_MOVIE_ID, movieId);

        return intent;
    }

    @Bind(R.id.movieTitle)
    TextView movieTitle;

    @Bind(R.id.posterImage)
    ImageView moviePoster;

    @Bind(R.id.movieOverview)
    TextView movieOverview;

    private MovieDetailsPresenter presenter;
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);

        imageLoader = new ImageLoader();

        movieDetailsUseCase = provideMovieDetailsUseCase();

        presenter = new MovieDetailsPresenter(movieDetailsUseCase);
    }

    private MovieDetailsUseCase provideMovieDetailsUseCase() {
        Object lastNonConfigurationInstance = getLastNonConfigurationInstance();
        if (lastNonConfigurationInstance == null) {
            MovieApplication movieApplication = (MovieApplication) getApplicationContext();
            return new MovieDetailsUseCase(movieApplication.movieDetailsRepository(), movieApplication.createSubscriberThread(), movieApplication.createObserverThread());
        }
        return ((MovieDetailsUseCase) lastNonConfigurationInstance);
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        return movieDetailsUseCase;
    }

    @Override
    public void display(MovieDetails movieDetails) {
        movieTitle.setText(movieDetails.originalTitle());
        movieOverview.setText(movieDetails.overview());
        imageLoader.loadWebImageInto(Uri.parse(movieDetails.posterPath()), moviePoster);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.startPresenting(this, getMovieId());
    }

    @Override
    protected void onStop() {
        presenter.stopPresenting();
        super.onStop();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Cannot load movie details for id:" + getMovieId(), Toast.LENGTH_LONG).show();
    }

    private long getMovieId() {
        return getIntent().getLongExtra(EXTRA_MOVIE_ID, -1L);
    }
}

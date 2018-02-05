package com.tobi.movies.posterdetails;

import android.support.annotation.Nullable;

import com.tobi.movies.misc.AbstractObserver;

import rx.Scheduler;
import rx.Subscription;

public class MovieDetailsUseCase implements MovieDetailsMVP.Model {

    private static final Listener NO_OP_LISTENER = new Listener() {

        @Override
        public void onMovieDetails(MovieDetails movieDetails) {
            //no op
        }

        @Override
        public void onError(Throwable throwable) {
            // nop op
        }
    };

    interface Listener {
        void onMovieDetails(MovieDetails movieDetails);

        void onError(Throwable throwable);
    }

    private final MovieDetailsRepository repository;
    private final Scheduler schedulerThread;
    private final Scheduler observerThread;

    @Nullable
    private Subscription subscription;
    private Listener listener = NO_OP_LISTENER;

    public MovieDetailsUseCase(
            MovieDetailsRepository repository,
            Scheduler schedulerThread,
            Scheduler observerThread) {
        this.repository = repository;
        this.schedulerThread = schedulerThread;
        this.observerThread = observerThread;
    }

    @Nullable
    private MovieDetails movieDetails;

    @Override
    @Nullable
    public MovieDetails getMovieDetails() {
        return movieDetails;
    }

    @Override
    public void loadMovieDetails(long movieId) {
        if (subscription != null) {
            subscription.unsubscribe();
        }

        subscription = repository
                .getMovieDetails(movieId)
                .subscribeOn(schedulerThread)
                .observeOn(observerThread)
                .subscribe(new AbstractObserver<MovieDetails>() {

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }

                    @Override
                    public void onNext(MovieDetails movieDetails) {
                        MovieDetailsUseCase.this.movieDetails = movieDetails;
                        listener.onMovieDetails(movieDetails);
                    }
                });
    }

    void setListener(@Nullable Listener listener) {
        this.listener = listener == null ? NO_OP_LISTENER : listener;
    }
}

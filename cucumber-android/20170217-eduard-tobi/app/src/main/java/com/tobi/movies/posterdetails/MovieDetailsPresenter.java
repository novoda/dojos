package com.tobi.movies.posterdetails;

public class MovieDetailsPresenter implements MovieDetailsMVP.Presenter {

    private final MovieDetailsUseCase movieDetailsUseCase;

    public MovieDetailsPresenter(MovieDetailsUseCase movieDetailsUseCase) {
        this.movieDetailsUseCase = movieDetailsUseCase;
    }

    @Override
    public void startPresenting(final MovieDetailsMVP.View movieDetailsView, long movieId) {
        MovieDetails movieDetails = movieDetailsUseCase.getMovieDetails();
        if (movieDetails != null) {
            movieDetailsView.display(movieDetails);
        } else {
            movieDetailsUseCase.setListener(new MovieDetailsUseCase.Listener() {
                @Override
                public void onMovieDetails(MovieDetails movieDetails) {
                    movieDetailsView.display(movieDetails);
                }

                @Override
                public void onError(Throwable throwable) {
                    movieDetailsView.showError();
                }
            });

            movieDetailsUseCase.loadMovieDetails(movieId);
        }

    }

    @Override
    public void stopPresenting() {
        movieDetailsUseCase.setListener(null);
    }
}

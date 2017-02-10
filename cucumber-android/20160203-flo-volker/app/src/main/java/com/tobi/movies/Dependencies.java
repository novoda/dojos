package com.tobi.movies;

import com.tobi.movies.popularstream.PopularStreamRepository;
import com.tobi.movies.posterdetails.MovieDetailsRepository;

import rx.Scheduler;

public interface Dependencies {

    ImageLoader imageLoader();

    PopularStreamRepository streamRepository();

    MovieDetailsRepository movieDetailsRepository();

    Scheduler createSubscriberThread();

    Scheduler createObserverThread();
}

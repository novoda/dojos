package com.tobi.movies;

public interface Converter<T, R> {

    R convert(T input);
}

package com.novoda.room.kata;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.novoda.room.kata.entity.Photo;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(AndroidJUnit4.class)
public class RoomKataTest {

    private RoomKata roomKata;

    @Before
    public void setUp() {
        roomKata = new RoomKata();
        roomKata.initialize(InstrumentationRegistry.getContext());
    }

    @Test
    public void givenAListOfPhotos_whenInsertingAllPhotos_thenTheyArePersistedInDB() {
        Photo photo1 = new Photo(1, "photo1", "http://wwww.image.com/image1.png", "first image", "2017-03-18");
        Photo photo2 = new Photo(2, "photo2", "http://wwww.image.com/image2.png", "second image", "2017-03-19");
        Photo photo3 = new Photo(3, "photo3", "http://wwww.image.com/image3.png", "third image", "2017-03-20");
        List<Photo> photos = Arrays.asList(photo1, photo2, photo3);

        roomKata.insert(photos);

        assertThat(roomKata.retrieveAll()).isEqualTo(photos);
    }

    @Test
    public void givenASinglePhoto_whenInsertingPhoto_thenItIsPersistedInDB() {
        Photo photo = new Photo(1, "photo1", "http://wwww.image.com/image1.png", "first image", "2017-03-18");

        roomKata.insert(photo);

        assertThat(roomKata.retrieveAll()).contains(photo);
    }

    @Test
    public void givenPhotoWithIdInDb_whenLoadingById_thenReturnsPhotoFromDb() {
        Photo photo = new Photo(666, "photo", "http://wwww.image.com/image1.png", "first image", "2017-03-18");
        roomKata.insert(photo);

        Photo returnedPhoto = roomKata.retrieveWithId(666);

        assertThat(returnedPhoto).isEqualTo(photo);
    }

    @Test
    public void givenPhotoInDB_whenDeletingPhoto_thenDeletesPhotoFromDb() {
        Photo photo = new Photo(1, "photo", "http://wwww.image.com/image1.png", "first image", "2017-03-18");
        roomKata.insert(photo);

        roomKata.delete(photo);

        assertThat(roomKata.retrieveAll()).isEmpty();
    }

}

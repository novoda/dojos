package com.novoda.room.kata.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Photo {

    @PrimaryKey
    public final int id;
    public final String title;
    public final String imageUrl;
    public final String comment;
    public final String publicationDate;

    public Photo(int id, String title, String imageUrl, String comment, String publicationDate) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.comment = comment;
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Photo photo = (Photo) o;

        if (id != photo.id) {
            return false;
        }
        if (!title.equals(photo.title)) {
            return false;
        }
        if (!imageUrl.equals(photo.imageUrl)) {
            return false;
        }
        if (!comment.equals(photo.comment)) {
            return false;
        }
        return publicationDate.equals(photo.publicationDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + imageUrl.hashCode();
        result = 31 * result + comment.hashCode();
        result = 31 * result + publicationDate.hashCode();
        return result;
    }
}

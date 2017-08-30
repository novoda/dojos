package com.novoda.room.kata.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Photo {
    @PrimaryKey
    private int id;

    private final String title;
    private final String imageUrl;
    private final String comment;
    private final String publicationDate;

    public Photo(int id, String title, String imageUrl, String comment, String publicationDate) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.comment = comment;
        this.publicationDate = publicationDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getComment() {
        return comment;
    }

    public String getPublicationDate() {
        return publicationDate;
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

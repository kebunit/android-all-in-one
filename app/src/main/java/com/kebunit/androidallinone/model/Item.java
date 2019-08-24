package com.kebunit.androidallinone.model;

import android.graphics.Bitmap;

public class Item {
    private String title, description;
    private Bitmap image;

    public Item(String title, String description, Bitmap image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public Item(String title, Bitmap image) {
        this.title = title;
        this.image = image;
        this.description="";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}

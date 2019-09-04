package com.kebunit.androidallinone.activity.searchview;

public class SearchQuery {
    private String query;
    private int image;

    public SearchQuery(String query, int image) {
        this.query = query;
        this.image = image;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

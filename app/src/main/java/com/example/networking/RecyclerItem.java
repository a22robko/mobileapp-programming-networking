package com.example.networking;

import android.view.View;

@SuppressWarnings("WeakerAccess")
public class RecyclerItem {

    private String title;

    public RecyclerItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

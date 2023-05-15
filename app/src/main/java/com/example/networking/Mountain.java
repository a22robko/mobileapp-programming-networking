package com.example.networking;

import androidx.annotation.NonNull;

public class Mountain {
    private String name;
    private String type;
    private String location;

    public Mountain(String name, String type, String location) {
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", " + type + ", " + location;
    }
}

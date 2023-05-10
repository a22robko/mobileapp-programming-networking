package com.example.networking;

public class Mountain {
    private String name;
    private String type;
    private int size;
    private String company;
    private String location;
    private String category;
    private String cost;
    private String ID;

    public Mountain(String name, int size) {
        this.name=name;
        this.size=size;
    }

    public static int length;

    public String getName() {return name ;
    }     public void setname(String name){ this.name= name;}


    public int getsize() {return size;}
    public void setSize(int size){ this.size = size;}
}

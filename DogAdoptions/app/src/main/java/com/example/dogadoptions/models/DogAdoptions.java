package com.example.dogadoptions.models;

// Our dog object.
public class DogAdoptions {
    public String name;
    public int drawableId;
    public String description;

    public DogAdoptions(String name, int drawableId, String description) {
        this.name = name;
        this.drawableId = drawableId;
        this.description = description;
    }
}

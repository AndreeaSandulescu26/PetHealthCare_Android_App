package com.example.pethealthcare;

public class PetModel {
    int img;
    String name, species, breed, age, gender;

    public PetModel(int img, String name, String species, String breed, String age, String gender){
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.img = img;
    }

    public PetModel(String name, String species, String breed, String age, String gender){
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
    }

}

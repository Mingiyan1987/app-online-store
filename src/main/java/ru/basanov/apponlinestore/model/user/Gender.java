package ru.basanov.apponlinestore.model.user;

public enum Gender {

    MALE("Мужской пол"),

    FEMALE("Женский пол");

    private String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package ru.basanov.apponlinestore.model;

public enum ProductStatus {

    Create("Товар создан"),

    Publish("Товар опубликован для продажи"),

    Deleted("Товар удален");

    private String description;

    ProductStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

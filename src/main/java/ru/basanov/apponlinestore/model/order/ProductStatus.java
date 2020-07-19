package ru.basanov.apponlinestore.model.order;

public enum ProductStatus {

    Create("Продукт создан"),

    Publish("Продукт опубликован для продажи"),

    Deleted("Продукт удален");

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

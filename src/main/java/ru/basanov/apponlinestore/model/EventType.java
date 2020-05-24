package ru.basanov.apponlinestore.model;

public enum EventType {

    START("Процесс запущен"),

    STOP("Процесс остановлен"),

    DESTROYED("Произошла ошибка");

    private String description;

    EventType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

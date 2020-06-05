package ru.basanov.apponlinestore.model;

public enum AccountStatus {

    NonConfirmed("Аккаунт не подтврежден"),

    Confirmed("Аккаунт подтвержден"),

    Deleted("Аккаунт удален");

    private String description;

    AccountStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

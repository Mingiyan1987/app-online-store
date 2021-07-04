package ru.basanov.apponlinestore.model.order;

public enum OrderElementStatus {

    NOT_CONFIRMED("В ожидании подтверждения"),

    REFUSED("Отказано продавцом"),

    ANNULLED("Отказано из-за неуплаты"),

    CANCELLED("Отменен покупателем"),

    CONFIRMED("Подтвержден продавцом"),

    EXECUTED("Выполнен"),

    COMPLETED("Выполнен, оплата перечислена");

    private String description;

    OrderElementStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

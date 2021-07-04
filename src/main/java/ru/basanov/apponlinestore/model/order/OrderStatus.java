package ru.basanov.apponlinestore.model.order;

public enum OrderStatus {

    UNAUTHENTICATED_CART("В корзине не авторизованого покупателя"),

    CART("В корзине авторизованного покупателя"),

    NOT_CONFIRMED("В ожидании подтверждения"),

    CONFIRMED("Подтвержден, ожидает оплаты"),

    CANCELLED("Аннулирован"),

    CANCELLED_BY_BUYER("Отменен заказчиком"),

    PAID_PARTLY("Оплачен частично"),

    PAID("Оплачен, ожидает исполения"),

    EXECUTED("Выполнен");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

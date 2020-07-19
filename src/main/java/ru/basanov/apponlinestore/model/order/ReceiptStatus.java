package ru.basanov.apponlinestore.model.order;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReceiptStatus {

    PAYMENT_SENT(0, "Отправлен платеж"),

    PAYMENT_DELIVERED(1, "Доставлен платеж"),

    PAYMENT_ERROR(2,"Ошибка платежа"),

    REFUND_SENT(3, "Отправлен возврат"),

    REFUND_DELIVERED(4, "Доставлен возврат"),

    REFUND_ERROR(5, "Ошибка возврата");

    private int code;

    private String description;

    ReceiptStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ReceiptStatus getByCode(int code) {
        return Arrays.stream(values())
                .filter(e -> e.getCode() == code)
                .findFirst().orElse(null);
    }
}

package ru.basanov.apponlinestore.model.product.feature.params;

import lombok.Getter;
import ru.basanov.apponlinestore.model.order.OrderElementDTO;

@Getter
public enum DeliveryType {

    NO_DELIVERY("Доставка не требуется (самовывоз)") {
        @Override
        public int countPrice(OrderElementDTO orderElementDTO) {
            return 0;
        }

        @Override
        public String getMessage(OrderElementDTO orderElementDTO) {
            return "Покупатель заберет товар на складе продавца, по адресу: ";
        }
    },

    FREE_UNLIMITED("Доставка: бесплатная неограниченная") {
        @Override
        public int countPrice(OrderElementDTO orderElementDTO) {
            return 0;
        }

        @Override
        public String getMessage(OrderElementDTO orderElementDTO) {
            return "Доставка бесплатная.";
        }
    },

    FREE_LIMITED_PLUS_DISTANCE("доставка: бесплатня ограниченная + за километраж") {
        @Override
        public int countPrice(OrderElementDTO orderElementDTO) {
            return 0;
        }

        @Override
        public String getMessage(OrderElementDTO orderElementDTO) {
            return null;
        }
    }

    ;

    private String name;

    DeliveryType(String name) {
        this.name = name;
    }

    public abstract int countPrice(OrderElementDTO orderElementDTO);

    public abstract String getMessage(OrderElementDTO orderElementDTO);
}

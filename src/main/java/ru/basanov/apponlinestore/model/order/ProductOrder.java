package ru.basanov.apponlinestore.model.order;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.basanov.apponlinestore.model.user.Account;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Account buyer;

    /** Дата и время регистрации (дата отправки заказа от покупателя к продацу)*/
    @NotNull
    @Column(name = "registration_date")
    private Instant registrationDate = Instant.now();

    private int price;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status = OrderStatus.CART;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @OrderBy
    private List<OrderElement> elements = new LinkedList<>();

    @OneToMany(mappedBy = "productOrder", cascade = CascadeType.ALL)
    private List<Payment> payments = new LinkedList<>();


    public ProductOrder(Account buyer) {
        this.buyer = buyer;
    }

    /**
     * Определяет был ли заказ полностью оплачен.
     *
     * @return полностью ли оплачен заказ
     */
    public boolean isFullPaid() {
        return getConfirmedPayments().stream()
                .map(Payment::getPrice)
                .reduce((p1, p2) -> p1.add(p2))
                .orElse(BigDecimal.ZERO).doubleValue() == price;
    }

    /**
     * Возвращает список подтвержденных платежей.
     *
     * @return список потвержденных платежей
     */
    private List<Payment> getConfirmedPayments() {
        return getPayments().stream()
                .filter(p -> p.getStatus() == Payment.PaymentStatus.CONFIRMED
                || p.getStatus() == Payment.PaymentStatus.REFUNDED)
                .collect(Collectors.toList());
    }

    /**
     * Считает сумму у всех пунктов заказа.
     *
     * @return сумму
     */
    public int getPrice() {
        price = elements.stream().mapToInt(OrderElement::getPrice).sum();
        return price;
    }

    /**
     * Добавить элемент к заказу.
     *
     * @param element элемент заказа
     */
    public void addElement(OrderElement element) {
        elements.add(element);
        element.setOrder(this);
    }

    /**
     * Удалить элемент из заказа.
     *
     * @param element элемент заказа
     */
    public void removeElement(OrderElement element) {
        elements.remove(element);
        element.setOrder(null);
    }

    /**
     * Очищает список элементов заказа.
     */
    public void clearElements() {
        for (OrderElement element : new ArrayList<>(elements)) {
            removeElement(element);
        }
    }
}

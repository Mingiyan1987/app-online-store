package ru.basanov.apponlinestore.model.order;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum PaymentMethod {

        MANDARINPAY("MandarinPay"),

        SBERBANK("Sberbank"),

        BANK_ACCOUNT("Бановский счет");

        private String description;

        PaymentMethod(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return description;
        }

    }

    public enum PaymentStatus {

        CONFIRMED("Подтвержден"),

        NOT_CONFIRMED("Не подтвержден"),

        REFUNDED("Возвращен");

        private String description;

        PaymentStatus(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }

    }

    @ManyToOne
    @NotNull
    @JoinColumn(name = "product_order_id")
    private ProductOrder productOrder;

    @Enumerated(EnumType.STRING)
    @NotNull
    private PaymentStatus status;

    @Column(name = "pay_date")
    private Date payDate;

    @NotNull
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(unique = true, name = "payment_number")
    @NotNull
    private String paymentNumber;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "payment", orphanRemoval = true)
    private Set<Receipt> receipts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,
        mappedBy = "payment", orphanRemoval = true)
    private Set<Refund> refunds = new HashSet<>();

    /**
     * Возвращает сумму, уплаченную по данному элементу заказа этим платежом.
     *
     * @param element элемент заказа
     * @return уплаченная сумма по элементу заказа этим платежом
     */
    public BigDecimal getAmountPaid(OrderElement element) {
        return new BigDecimal(element.getPrice())
                .multiply(getPaidPercent())
                .divide(new BigDecimal(100));
    }

    /**
     * Возвращает процент от общего счета, оплаченный этим платежом.
     *
     * @return оплаченный процент от общего счета
     */
    public BigDecimal getPaidPercent() {
        return price
                .divide(new BigDecimal(productOrder.getPrice()))
                .multiply(new BigDecimal(100));
    }

    /**
     * Возвращает сумму, которая уже была возвращена по переданному элементу
     * заказа по всем возвратам.
     *
     * @param element элемент заказа
     * @return возвращенную клиенту сумму по данной позиции
     */
    public BigDecimal getAmountRefunded(OrderElement element) {
        return refunds.stream()
                .map(refund -> refund.getAmountRefunded(element))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

}

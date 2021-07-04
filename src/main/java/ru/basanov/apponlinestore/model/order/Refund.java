package ru.basanov.apponlinestore.model.order;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@NoArgsConstructor
@Table(name = "refund")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @CreationTimestamp
    private Date date;

    @ElementCollection
    @MapKeyJoinColumn(name = "orderElement_id")
    private Map<OrderElement, BigDecimal> elements = new HashMap<>();

    public Refund(Payment payment, Map<OrderElement, Integer> refundMap) {

        for (OrderElement element: payment.getProductOrder().getElements()) {
            BigDecimal elementPaid = payment.getAmountPaid(element);
            BigDecimal percentRefunded = new BigDecimal(refundMap.get(element));
            BigDecimal sumRefunded = elementPaid
                    .multiply(percentRefunded)
                    .divide(new BigDecimal(100));
            elements.put(element, sumRefunded);
        }
    }

    /**
     * Возвращает финальную сумму возврата.
     *
     * @return сумма возврата по всем элементам заказа
     */
    public BigDecimal getTotalAmount() {
        return elements.values().stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    /**
     * Возвращает сумму возврата по конкретной позиции.
     *
     * @param orderElement элемент заказа
     * @return сумму возврата по конкретной позиции
     */
    public BigDecimal getAmountRefunded(OrderElement orderElement) {
        return elements.get(orderElement);
    }

    /**
     * Возвращает процент возврата по конкретной позиции.
     *
     * @param orderElement элемент заказа
     * @return процент возврата по конкретной позиции
     */
    public int getPercentRefunded(OrderElement orderElement) {
        BigDecimal elementPrice = new BigDecimal(orderElement.getPrice())
                .multiply(payment.getPaidPercent())
                .divide(new BigDecimal(100));
        BigDecimal refundedSum = elements.get(orderElement);
        return refundedSum
                .divide(elementPrice, 2, BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal(100))
                .intValue();
    }

}

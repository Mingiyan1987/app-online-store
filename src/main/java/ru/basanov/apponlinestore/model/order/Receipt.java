package ru.basanov.apponlinestore.model.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "receipt")
public class Receipt implements Serializable {

    @Id
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Enumerated(EnumType.STRING)
    private ReceiptStatus receiptStatus;

    /** Номер чека в смене */
    private Integer shiftNumber;

    /** Дата и время чека в фискальном накопителе */
    private Integer fiscalReceiptNumber;

    /** Номер фискального накопителя */
    private Instant receiptDateTime;

    /** Регистрационный номер ERC */
    private Long fnNumber;

    /** Фискальный номер документа */
    private Long ecrRegistrationNumber;

    /** Фискальный признак документа */
    private Long fiscalDocumentNumber;

    /** Фискальный признак документа */
    private Long fiscalDocumentAttribute;

    /** Итоговая сумма чека */
    private BigDecimal amountTotal;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Receipt)) {
            return false;
        }

        Receipt receipt = (Receipt) o;

        return this.uuid != null ? this.uuid.equals(receipt.getUuid()) : receipt.getUuid() == null;

    }

    @Override
    public int hashCode() {
        return this.uuid != null ? this.uuid.hashCode() : 0;
    }
}

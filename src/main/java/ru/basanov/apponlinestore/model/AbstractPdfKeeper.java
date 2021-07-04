package ru.basanov.apponlinestore.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractPdfKeeper {

    @Column(name = "pdf")
    protected String pdf;

    public boolean hasPdf() {
        return pdf != null;
    }

    // Реализовать в следующем коммите
    public byte[] getPdf() {
        if (pdf == null) {
            return new byte[]{};
        }
        return null;
    }
}

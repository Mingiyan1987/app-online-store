package ru.basanov.apponlinestore.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "time_zone")
    private String timeZone;

    /**
     * Адрес базовой точки региона для использования на картах.
     */
    private String geoAddress;

    public Region(String name, String timeZone) {
        this.name = name;
        this.timeZone = timeZone;
    }
}

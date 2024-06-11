package com.montrack.montrack.trx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trx")
public class trx {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trx_id_gen")
    @SequenceGenerator(name = "trx_id_gen", sequenceName = "trx_id_seq")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "attachment")
    private String attachment;

    @NotNull
    private int amount;

}

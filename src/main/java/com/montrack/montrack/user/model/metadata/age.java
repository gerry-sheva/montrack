package com.montrack.montrack.user.model.metadata;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "age")
public class age {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "age_id_gen")
    @SequenceGenerator(name = "age_id_gen", sequenceName = "age_id_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "age", nullable = false)
    private String age;
}

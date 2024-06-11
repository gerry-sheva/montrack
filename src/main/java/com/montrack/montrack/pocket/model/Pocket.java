package com.montrack.montrack.pocket.model;

import com.montrack.montrack.wallet.model.Wallet;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pocket")
public class Pocket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pocket_id_gen")
    @SequenceGenerator(name = "pocket_id_gen", sequenceName = "pocket_id_seq")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "emoji")
    private String emoji;

    @NotNull
    @Column(name = "balance")
    private int balance;

    @NotNull
    @Column(name = "expense")
    private int expense;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;
}

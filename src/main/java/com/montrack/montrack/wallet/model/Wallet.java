package com.montrack.montrack.wallet.model;

import com.montrack.montrack.user.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wallet_id_gen")
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String currency;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Positive
    @Column(name = "balance",nullable = false)
    private Long balance;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}

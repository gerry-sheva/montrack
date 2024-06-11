package com.montrack.montrack.user.model;

import com.montrack.montrack.auth.model.UserAuth;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;

    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;

    @OneToOne(mappedBy = "user")
    private UserAuth userAuth;

    private Long activeWalletId;

}

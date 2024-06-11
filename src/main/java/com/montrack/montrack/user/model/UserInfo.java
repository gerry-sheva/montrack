package com.montrack.montrack.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @NotNull
    @Column(name = "fname", nullable = false)
    private String fname;

    @NotNull
    @Column(name = "lname", nullable = false)
    private String lname;
}

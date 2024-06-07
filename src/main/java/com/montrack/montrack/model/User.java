package com.montrack.montrack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Data
@Table("users")
public class User {
    @Id
    private Long id;
    @Column
    private Timestamp createdAt;
    @Column
    private Timestamp updatedAt;
    @Column
    private Timestamp deletedAt;
}

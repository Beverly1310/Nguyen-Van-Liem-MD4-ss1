package com.ra.ss.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String departName;
    private Boolean status;
}

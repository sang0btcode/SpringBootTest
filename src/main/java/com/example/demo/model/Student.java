package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String address;
    private Integer age;
    private Integer sex;
    private Double mathScore;
    private Double literatureScore;
    private Double engllishScore;



}

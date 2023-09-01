package com.test.study.user.model.entity;


import com.test.study.util.entity.Base;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="user")
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userSeq;

    @Column(length = 20, unique = true, nullable = false)
    private String id;

    @Column(length = 500, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 10/*, nullable = true*/)
    private String gender;

    @Column/*(nullable = true)*/
    private int age;

    @Column(length = 20, nullable = false)
    private String email;
}

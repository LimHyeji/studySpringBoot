package com.test.study.card.model.entity;

import com.test.study.util.entity.Base;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="card")
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Card extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardSeq;

    @Column(length = 20, nullable = false)
    private String company;

    @Column(length = 10, nullable = false)
    private String type;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String cardImage;
}

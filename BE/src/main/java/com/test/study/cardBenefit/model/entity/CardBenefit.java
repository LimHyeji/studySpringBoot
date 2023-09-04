package com.test.study.cardBenefit.model.entity;

import com.test.study.card.model.entity.Card;
import com.test.study.shopBrand.model.entity.ShopBrand;
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
public class CardBenefit extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardBenefitSeq;

    /* 혜지 : FK 설정 필요 */
    private ShopBrand shopBrand;

    /* 혜지 : FK 설정 필요 */
    private Card card;

    @Column(length = 100)
    private String content;

    @Column
    private double discount;

    @Column
    private double point;

    @Column
    private double cashBack;
}

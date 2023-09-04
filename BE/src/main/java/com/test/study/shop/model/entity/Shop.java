package com.test.study.shop.model.entity;

import com.test.study.shopBrand.model.entity.ShopBrand;
import com.test.study.util.entity.Base;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="shop")
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Shop extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shopSeq;

    /* 혜지 : FK 설정 필요 */
    @OneToOne
    private ShopBrand shopBrand;

    @Column(length = 20, nullable = false)
    private String location;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(nullable = false)
    private long latitude;

    @Column(nullable = false)
    private long longitude;
}

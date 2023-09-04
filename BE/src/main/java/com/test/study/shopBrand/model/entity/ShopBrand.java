package com.test.study.shopBrand.model.entity;

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
public class ShopBrand extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shopBrandSeq;

    @Column(length = 20, nullable = false)
    private String mainCategory;

    @Column(length = 20, nullable = false)
    private String subCatagory;

    @Column(length = 20, nullable = false)
    private String name;
}

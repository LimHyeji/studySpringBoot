package com.test.study.giftCard.model.entity;

import com.test.study.shopBrand.model.entity.ShopBrand;
import com.test.study.user.model.entity.User;
import com.test.study.util.entity.Base;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name="giftCard")
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GiftCard extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long giftCardSeq;

    /* 혜지 : FK 설정 필요 */
    private User user;

    /* 혜지 : FK 설정 필요 */
    private ShopBrand shopBrand;

    @Column(length = 20, nullable = false)
    private String productName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String barcodeImage;

    @Column(nullable = false, unique = true)
    private long barcodeNumber;

    @Column(nullable = false)
    private LocalDateTime dueDate;

}

package com.test.study.userBookMark.model.entity;

import com.test.study.shop.model.entity.Shop;
import com.test.study.user.model.entity.User;
import com.test.study.util.entity.Base;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="userBookMark")
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserBookMark extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userBookMarkSeq;

    /* 혜지 : FK 확인 필요 (양방향) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId",referencedColumnName = "id")
    private User user;

    /* 혜지 : FK 확인 필요 (양방향) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shopSeq", referencedColumnName = "shopSeq")
    private Shop shop;
}

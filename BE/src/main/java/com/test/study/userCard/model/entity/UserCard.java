package com.test.study.userCard.model.entity;

import com.test.study.card.model.entity.Card;
import com.test.study.user.model.entity.User;
import com.test.study.util.entity.Base;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="userCard")
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCard extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userCardSeq;

    /* 혜지 : FK 확인 필요 (양방향) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", referencedColumnName = "id")
    private User user;

    /* 혜지 : FK 확인 필요 (단방향) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cardName", referencedColumnName = "name")
    private Card card;
}

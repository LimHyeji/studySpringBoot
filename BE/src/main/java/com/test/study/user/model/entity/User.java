package com.test.study.user.model.entity;


import com.test.study.giftCard.model.entity.GiftCard;
import com.test.study.userBookMark.model.entity.UserBookMark;
import com.test.study.userCard.model.entity.UserCard;
import com.test.study.util.entity.Base;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="user")
@Table(indexes = {
        @Index(name = "user_id",columnList = "id"),
        @Index(name = "user_email",columnList = "email"),
})
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

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 10)
    private String gender;

    @Column
    private int yearOfBirth;

    @OneToMany(mappedBy = "user")
    private List<GiftCard> giftCards;

    @OneToMany(mappedBy = "user")
    private List<UserCard> userCards;

    @OneToMany(mappedBy = "user")
    private List<UserBookMark> userBookMarks;
}

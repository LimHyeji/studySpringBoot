package com.test.study;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user")
public class User {
    @Id
    @Column(name="user_id", length = 20)
    private String userId;

    @Column(name="user_pw",length = 20)
    private String userPw;
}

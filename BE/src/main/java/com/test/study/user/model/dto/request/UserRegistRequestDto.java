package com.test.study.user.model.dto.request;

import jakarta.annotation.Nullable;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegistRequestDto {

    private String id;

    private String password;

    private String passwordCheck;

    private String name;

    @Nullable
    private String gender;

    @Nullable
    private int age;

    private String email;

}

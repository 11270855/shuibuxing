package com.booksystem.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class User {
    private Integer id;
    @NonNull
    private String nickname;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String avatar;
    @NonNull
    private Integer gender;
    private Integer permissions;
    private Integer deleteFlag;
    private LocalDateTime createTime;
}

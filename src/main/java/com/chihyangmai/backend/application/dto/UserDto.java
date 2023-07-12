package com.chihyangmai.backend.application.dto;

import com.chihyangmai.backend.domain.entity.User;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;

    public static UserDto from (User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}

package com.sns.untitled.user.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {

    @NotBlank
    private int userId;

    @NotBlank
    @Size(min=10, max=45)
    private String id;

    // user가 사용하는 비밀번호
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9~!@#$%^&*()+|=]{10,45}")
    private String password;

    // user의 이름
    @NotBlank
    @Size(min=1, max=10)
    private String name;
    
    // user의 이메일 + 이메일 type임을 확인하기 위해서 @valid에서 확인
    @NotBlank
    @Email
    private String email;

    // user의 생일은 과거 혹은 현재만 입력 가능하도록 제한
    @Nullable
    @PastOrPresent
    private Date birth;
    
    // profile 관련(이미지 설명, 경로, 이름)은 null일 수 있도록 설정
    @Nullable
    private String profileImageName;

    @Nullable
    private String profileImagePath;

    @Nullable
    private String profileMessage;
}

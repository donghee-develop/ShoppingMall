package com.koreamall.dto.user;

import com.koreamall.dto.FileDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

// extends User 를 사용할 수 있음 그럴경우 생성자를 만들어야함, 오버라이드 필요 없음
public class UserDTO implements UserDetails,OAuth2User {

    @NotBlank
    @Length(min=4, max=10)
//    @Pattern(regexp = "[a-z]*[A-Z]*[0,9]" flags=Pattern)
    private String id;
    private String ci;
    private String password;
    @Email
    private String email;
    private String phone;
    private String name;
    private String nickName;
    private FileDTO profileImg;
    private Map<String,Object> attributes;

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }


    // 권한을 반환해야함
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER")); // 롤에 아무거나 써도 됨
    }

    @Override
    public String getUsername() {
        return this.id; // 무조건 id 리턴해줘야함
    }

    // 밑에는 다 트루헤줘도 됨
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}

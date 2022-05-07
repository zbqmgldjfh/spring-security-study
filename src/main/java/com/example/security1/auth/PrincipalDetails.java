package com.example.security1.auth;

import com.example.security1.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// Security가 /login으로 요청온 로그인 처리를 대신 진행한다.
// 로그인이 정상적으로 진행되면 Security Session에 저장하게 된다.
// 이때 Security ContextHolder를 key값으로 저장한다.
// Security Session 에 저장될 수 있는 객체의 타입이 정해져 있는데, Authentication 타입의 객체이다.
// Authentication 타입 안에 user 정보가 있는데,
// User Object Type => UserDetails 타입 객체

@AllArgsConstructor
public class PrincipalDetails implements UserDetails {

    private User user;

    // 해당 User의 권한을 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add((GrantedAuthority) () -> user.getRole());
        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

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

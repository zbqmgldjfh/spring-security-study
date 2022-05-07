package com.example.security1.auth;

import com.example.security1.model.User;
import com.example.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 스프링 시큐리티 설정에서 loginProcessingUrl("/login") 으로 설정해준
// '/login' 요청이 오면 자동으로 UserDetailsService 타입인 PrincipalDetailsService bean의 loadUserByUsername 함수 호출

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User findUser = userRepository.findByUsername(username);
        if(findUser != null) {
            return new PrincipalDetails(findUser); // 반환된 UserDetails은 Authentication으로 들어감
        }
        return null;
    }
}

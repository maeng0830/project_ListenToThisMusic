package com.maeng0830.listentothismusic.config.auth;

import com.maeng0830.listentothismusic.domain.Member;
import com.maeng0830.listentothismusic.repository.MemberRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// loginProcessingUrl("/login");
// login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어있는 loadUserByUserName 메소드가 실행된다.
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    // 리턴 값은 Authentication 내부의 UserDetails에 전달된다.
    // 그리고 해당 Authentication은 Security Session 내부로 전달된다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findByEmail(username);

        if (member.isPresent()) {
            return new PrincipalDetails(member.get());
        }

        return null;
    }
}

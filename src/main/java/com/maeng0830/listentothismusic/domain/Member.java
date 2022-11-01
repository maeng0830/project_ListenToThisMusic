package com.maeng0830.listentothismusic.domain;

import com.maeng0830.listentothismusic.code.memberCode.MemberAuthorityCode;
import com.maeng0830.listentothismusic.code.memberCode.MemberStatusCode;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String email; // id
    String userName; // 이름
    String password; // 비밀번호
    String authKey; // 인증 키
    boolean authYn; // 가입 인증 여부
    LocalDateTime regDtt; // 가입 날짜

    @Enumerated(EnumType.STRING)
    MemberStatusCode status; // 상태(인증 요청, 사용, 정지, 탈퇴)

    String phone; // 연락처
    String nickName; // 닉네임

    @Enumerated(EnumType.STRING)
    MemberAuthorityCode authority; // ROLE_MEMBER, ROLE_ADMIN
}

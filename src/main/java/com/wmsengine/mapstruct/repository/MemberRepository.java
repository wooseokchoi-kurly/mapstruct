package com.wmsengine.mapstruct.repository;

import com.wmsengine.mapstruct.entity.Member;
import com.wmsengine.mapstruct.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    /**
     * team 으로 회원 조회
     *
     * @param team
     * @return
     */
    List<Member> findByTeam(Team team);
}

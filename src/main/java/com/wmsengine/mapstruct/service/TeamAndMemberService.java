package com.wmsengine.mapstruct.service;

import com.wmsengine.mapstruct.controller.dto.MemberDto;
import com.wmsengine.mapstruct.controller.dto.TeamAndMemberDto;
import com.wmsengine.mapstruct.controller.dto.TeamDto;

public interface TeamAndMemberService {

    /**
     * member 생성
     *
     * @param memberDto
     * @return
     */
    Long createMember(MemberDto memberDto);

    /**
     * member 수정
     *
     * @param memberDto
     * @return
     */
    Long updateMember(MemberDto memberDto);

    /**
     * team 생성
     *
     * @param teamDto
     * @return
     */
    Long createTeam(TeamDto teamDto);

    /**
     * team 수정
     *
     * @param teamDto
     * @return
     */
    Long updateTeam(TeamDto teamDto);

    /**
     * team, member 조회
     *
     * @param teamId
     * @return
     */
    TeamAndMemberDto getTeamAndMemberByTeamId(Long teamId);

}

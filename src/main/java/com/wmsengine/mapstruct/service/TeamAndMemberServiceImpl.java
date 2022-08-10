package com.wmsengine.mapstruct.service;

import com.wmsengine.mapstruct.controller.dto.MemberDto;
import com.wmsengine.mapstruct.controller.dto.TeamAndMemberDto;
import com.wmsengine.mapstruct.controller.dto.TeamDto;
import com.wmsengine.mapstruct.entity.Member;
import com.wmsengine.mapstruct.entity.Team;
import com.wmsengine.mapstruct.mapper.MemberMapper;
import com.wmsengine.mapstruct.mapper.TeamAndMemberDtoMapper;
import com.wmsengine.mapstruct.mapper.TeamMapper;
import com.wmsengine.mapstruct.repository.MemberRepository;
import com.wmsengine.mapstruct.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamAndMemberServiceImpl implements TeamAndMemberService {

    //repository
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    //mapper
    private final MemberMapper memberMapper;
    private final TeamMapper teamMapper;
    private final TeamAndMemberDtoMapper teamAndMemberDtoMapper;

    @Transactional
    @Override
    public Long createMember(MemberDto memberDto) {
        Team team = teamRepository.findById(memberDto.getTeamId()).orElseThrow(IllegalArgumentException::new);
        Member member = memberMapper.toEntity(memberDto);
        member.setTeam(team);
        Member newMember = memberRepository.save(member);

        return newMember.getId();
    }

    @Transactional
    @Override
    public Long updateMember(MemberDto memberDto) {
        Team team = teamRepository.findById(memberDto.getTeamId()).orElseThrow(IllegalArgumentException::new);
        Member member = memberRepository.findById(memberDto.getMemberId()).orElseThrow(IllegalArgumentException::new);

        memberMapper.updateEntity(memberDto, team, member);

        return member.getId();
    }

    @Transactional
    @Override
    public Long createTeam(TeamDto teamDto) {
        Team team = teamMapper.toEntity(teamDto);
        Team newTeam = teamRepository.save(team);

        return newTeam.getId();
    }

    @Transactional
    @Override
    public Long updateTeam(TeamDto teamDto) {
        Team team = teamRepository.findById(teamDto.getTeamId()).orElseThrow(IllegalArgumentException::new);
        teamMapper.updateEntity(teamDto, team);

        return team.getId();
    }

    @Transactional(readOnly = true)
    @Override
    public TeamAndMemberDto getTeamAndMemberByTeamId(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(IllegalArgumentException::new);
        List<Member> members = memberRepository.findByTeam(team);

        return teamAndMemberDtoMapper.toTeamAndMemberDto(team, members);
    }
}

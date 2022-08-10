package com.wmsengine.mapstruct.mapper;

import com.wmsengine.mapstruct.controller.dto.TeamAndMemberDto;
import com.wmsengine.mapstruct.entity.Member;
import com.wmsengine.mapstruct.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamAndMemberDtoMapper {

    //mapping: return 하는 객체의 속성값(target), 파라미터로 받아온 값(source)
    //TeamAndMemberDto 내에 있는 memberList 에 파라미터로 받아온 members 를 맵핑한다.
    @Mapping(target = "team", source = "team")
    @Mapping(target = "memberList", source = "members")
    TeamAndMemberDto toTeamAndMemberDto(Team team, List<Member> members);
}

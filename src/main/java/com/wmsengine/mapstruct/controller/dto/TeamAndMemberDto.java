package com.wmsengine.mapstruct.controller.dto;

import com.wmsengine.mapstruct.controller.dto.base.BaseDto;
import com.wmsengine.mapstruct.entity.Member;
import com.wmsengine.mapstruct.entity.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
public class TeamAndMemberDto extends BaseDto {
    private Team team;
    private List<Member> memberList;
}

package com.wmsengine.mapstruct.mapper;

import com.wmsengine.mapstruct.controller.dto.MemberDto;
import com.wmsengine.mapstruct.entity.Member;
import com.wmsengine.mapstruct.entity.Team;
import com.wmsengine.mapstruct.mapper.base.BaseMapper;
import com.wmsengine.mapstruct.repository.TeamRepository;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MemberMapper extends BaseMapper<MemberDto, Member>{

    @Mapping(target = "team", source = "teamId")
    Member toEntity(MemberDto memberDto, @Context TeamRepository teamRepository);

    default Team getTeam(Long teamId, @Context TeamRepository teamRepository) {
        return teamRepository.findById(teamId).orElseThrow(IllegalArgumentException::new);
    }

    @Mapping(target = "team", source = "team")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(MemberDto memberDto, Team team, @MappingTarget Member entity);
}

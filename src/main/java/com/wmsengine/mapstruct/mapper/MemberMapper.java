package com.wmsengine.mapstruct.mapper;

import com.wmsengine.mapstruct.controller.dto.MemberDto;
import com.wmsengine.mapstruct.entity.Member;
import com.wmsengine.mapstruct.entity.Team;
import com.wmsengine.mapstruct.mapper.base.BaseMapper;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MemberMapper extends BaseMapper<MemberDto, Member>{

    @Mapping(target = "team", source = "team")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(MemberDto memberDto, Team team, @MappingTarget Member entity);
}

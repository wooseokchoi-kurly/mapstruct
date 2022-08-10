package com.wmsengine.mapstruct.mapper;

import com.wmsengine.mapstruct.controller.dto.TeamDto;
import com.wmsengine.mapstruct.entity.Team;
import com.wmsengine.mapstruct.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper extends BaseMapper<TeamDto, Team> {
}

package com.wmsengine.mapstruct.mapper.base;

import com.wmsengine.mapstruct.controller.dto.base.BaseDto;
import com.wmsengine.mapstruct.entity.base.BaseEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

//BaseMapper: mapper 생성이 용이하게 BaseMapper 를 만듬
//Dto, Entity 의 타입을 제네릭으로 제한
public interface BaseMapper<DTO extends BaseDto, ENTITY extends BaseEntity> {
    DTO toDto(ENTITY e);

    ENTITY toEntity(DTO d);

    //nullValuePropertyMappingStrategy: Source 의 필드가 null 일 때의 정책 [SET_TO_NULL(기본값), SET_TO_DEFAULT, IGNORE]
    //여기서는 null 값인 것들은 무시한다.
    //mappingTarget: 파라미터로 받아 업데이트할 객체 설정한다.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(DTO dto, @MappingTarget ENTITY entity);
}
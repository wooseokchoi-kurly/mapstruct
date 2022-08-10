package com.wmsengine.mapstruct.controller.dto;

import com.wmsengine.mapstruct.controller.dto.base.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDto extends BaseDto {
    private Long memberId;
    private Long teamId;
    private String memberName;
    private Integer memberAge;
}

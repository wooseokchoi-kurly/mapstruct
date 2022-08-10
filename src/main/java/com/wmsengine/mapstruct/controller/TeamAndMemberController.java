package com.wmsengine.mapstruct.controller;

import com.wmsengine.mapstruct.controller.dto.MemberDto;
import com.wmsengine.mapstruct.controller.dto.TeamAndMemberDto;
import com.wmsengine.mapstruct.controller.dto.TeamDto;
import com.wmsengine.mapstruct.service.TeamAndMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TeamAndMemberController {

    private final TeamAndMemberService teamAndMemberService;

    @PostMapping("/v1/team-member/member")
    public ResponseEntity<?> createMember(@RequestBody MemberDto memberDto) {
        Long memberId = teamAndMemberService.createMember(memberDto);

        return ResponseEntity.ok(memberId);
    }

    @PutMapping("/v1/team-member/member")
    public ResponseEntity<?> updateMember(@RequestBody MemberDto memberDto) {
        Long memberId = teamAndMemberService.updateMember(memberDto);

        return ResponseEntity.ok(memberId);
    }

    @PostMapping("/v1/team-member/team")
    public ResponseEntity<?> createTeam(@RequestBody TeamDto teamDto) {
        Long teamId = teamAndMemberService.createTeam(teamDto);

        return ResponseEntity.ok(teamId);
    }

    @PutMapping("/v1/team-member/team")
    public ResponseEntity<?> updateTeam(@RequestBody TeamDto teamDto) {
        Long teamId = teamAndMemberService.updateTeam(teamDto);

        return ResponseEntity.ok(teamId);
    }

    @GetMapping("/v1/team-member/{teamId}")
    public ResponseEntity<?> getTeamAndMember(@PathVariable Long teamId) {
        TeamAndMemberDto teamAndMemberDto = teamAndMemberService.getTeamAndMemberByTeamId(teamId);

        return ResponseEntity.ok(teamAndMemberDto);
    }
}

package com.wmsengine.mapstruct.repository;

import com.wmsengine.mapstruct.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}

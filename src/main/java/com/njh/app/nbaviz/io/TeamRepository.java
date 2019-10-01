package com.njh.app.nbaviz.io;

import com.njh.app.nbaviz.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByTeamName(String teamName);
//    Team findByTeamId(String teamId);
}

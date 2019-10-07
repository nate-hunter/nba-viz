package com.njh.app.nbaviz.ui;

import com.njh.app.nbaviz.io.TeamRepository;
import com.njh.app.nbaviz.model.Team;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams")
    @CrossOrigin(origins = "http://localhost:3000")
    Collection<Team> teams() {
        return teamRepository.findAll();
    }

    @GetMapping("/team/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<Team> getTeam(@PathVariable Long id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

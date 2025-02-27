package com.jawbr.dnd5e.characterforge.controller;

import com.jawbr.dnd5e.characterforge.dto.response.subRace.SubRaceDTO;
import com.jawbr.dnd5e.characterforge.service.SubRaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subraces")
public class SubRaceController {

    private final SubRaceService subRaceService;

    public SubRaceController(SubRaceService subRaceService) {
        this.subRaceService = subRaceService;
    }

    @GetMapping
    public List<SubRaceDTO> findAllSubRaces() {
        return subRaceService.findAllSubRaces();
    }
}

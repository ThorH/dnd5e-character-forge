package com.jawbr.dnd5e.characterforge.service;

import com.jawbr.dnd5e.characterforge.dto.mapper.subRace.SubRaceDTOMapper;
import com.jawbr.dnd5e.characterforge.dto.response.subRace.SubRaceDTO;
import com.jawbr.dnd5e.characterforge.exception.RaceNotFoundException;
import com.jawbr.dnd5e.characterforge.repository.SubRaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="https://www.linkedin.com/in/bradley-sperling/">Bradley Jawwad</a>
 */
@Service
public class SubRaceService {

    private final SubRaceRepository subRaceRepository;
    private final SubRaceDTOMapper subRaceDTOMapper;

    private static final String URL = "/api/subraces/";

    public SubRaceService(SubRaceRepository subRaceRepository, SubRaceDTOMapper subRaceDTOMapper) {
        this.subRaceRepository = subRaceRepository;
        this.subRaceDTOMapper = subRaceDTOMapper;
    }

    /**
     * Method to find all sub-races inside the database
     *
     * @return a List containing all sub-races mapped into SubRaceDTO
     * @throws RaceNotFoundException when no sub-races are found inside the database
     * @author <a href="https://www.linkedin.com/in/bradley-sperling/">Bradley Jawwad</a>
     */
    public List<SubRaceDTO> findAllSubRaces() {
        return Optional.of(subRaceRepository.findAll())
                .filter(list -> !list.isEmpty())
                .map(list -> list.stream().map(subRaceDTOMapper).toList())
                .orElseThrow(() -> new RaceNotFoundException("No sub races found."));
    }
}

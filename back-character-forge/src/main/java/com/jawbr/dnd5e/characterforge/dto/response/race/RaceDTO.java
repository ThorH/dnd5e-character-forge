package com.jawbr.dnd5e.characterforge.dto.response.race;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jawbr.dnd5e.characterforge.model.util.Size;
import lombok.Builder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL) // Only show in the response fields that is not null
@Builder
public record RaceDTO(
        String index,
        String name,
        int speed,
        List<RaceAbilityBonusesDTO> ability_bonuses,
        // TODO - ability_bonus_option - For races like Half-elf that get +2 in CHA and +1 in another of player choice
        String alignment,
        String age,
        Size size,
        String size_description,
        /*
         * TODO -  starting_proficiencies []
         * TODO -  "starting_proficiency_options"
         */
        List<RaceLanguagesDTO> languages,
        // TODO -  "language_options"
        /*
         * IDEA - Can languages options be a true/false field and if it's true display all available languages
         * and only removes from the list languages that the race already knows
         */
        String language_desc,
        // traits []
        String url
) {
}

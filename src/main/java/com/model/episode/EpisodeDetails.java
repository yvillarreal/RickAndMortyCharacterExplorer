package com.model.episode;

import com.model.characters.Characters;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodeDetails {
    private Integer id;
    private String name;
    private String air_date;
    private String episode;
    private Characters characters;
}

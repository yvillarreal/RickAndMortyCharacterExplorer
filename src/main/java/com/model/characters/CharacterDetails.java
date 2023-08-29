package com.model.characters;

import com.model.episode.EpisodeDetails;
import com.model.origin.Origin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDetails {
    public String name;
    private String status;
    private String image;
    private String species;
    private Origin origin;
    private EpisodeDetails episodeDetails;
}


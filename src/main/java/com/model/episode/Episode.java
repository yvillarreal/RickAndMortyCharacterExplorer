package com.model.episode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Episode {
    private String url;

    public Episode(String url) {
        this.url = url;
    }
}

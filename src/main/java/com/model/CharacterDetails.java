package com.model;

import java.util.List;

public class CharacterDetails {
    public String name;
    private String status;
    private String image;

    private Origin origin;

    public List<Episode> getEpisode() {
        return episode;
    }

    public void setEpisode(List<Episode> episode) {
        this.episode = episode;
    }

    private List<Episode> episode;


    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}


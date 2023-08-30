package com.model.characters;

import com.model.Location;
import com.model.origin.Origin;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Characters {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;
}


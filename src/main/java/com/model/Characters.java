package com.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public @Data class Characters {
    private int id;
    public String name;
    private String status;
    private String species;
    private String image;
}


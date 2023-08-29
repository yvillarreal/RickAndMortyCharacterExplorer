package com.model.characters;

import com.model.info.Info;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterResponse {
    private Info info;
    private List<Characters> results;

}


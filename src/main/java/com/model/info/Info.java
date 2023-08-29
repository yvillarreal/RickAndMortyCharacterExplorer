package com.model.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Info {
    private int count;
    private int pages;
    private String next;
    private String prev;


}

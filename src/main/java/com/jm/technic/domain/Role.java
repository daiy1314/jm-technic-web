package com.jm.technic.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String type;

}

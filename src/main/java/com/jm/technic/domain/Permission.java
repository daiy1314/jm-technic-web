package com.jm.technic.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {
    private Integer id;
    private String url;
    private String name;
}

package com.jm.technic.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {
    private Integer id;
    private Integer uid;
    private Integer rid;
}

package com.jm.technic.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolePermission implements Serializable {
    private Integer id;
    private Integer rid;
    private Integer pid;
}

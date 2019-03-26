package com.jm.technic.domain;


import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private Integer id;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @Size(min = 6, max = 18, message = "密码最少6位,最多18位")
    private String password;
    @Min(value = 18, message = "年龄不能小于18岁")
    private Integer userAge;
    @NotBlank(message = "地址不能为空")
    private String userAddress;
    @Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "手机号填写错误")
    private String tel;
    @Email
    private String email;

    private Date lastLoginDate;

    private Date createDate;

    private Integer status;

    public User() {
        super();
    }

}
package com.demo.shiro.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author huanghao
 * date 2020-11-13
 */
@Data
public class User {
    private String id;
    private String name;
    private String password;
    private Set<Role> roles;
}

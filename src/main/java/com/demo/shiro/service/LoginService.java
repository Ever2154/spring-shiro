package com.demo.shiro.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;
import com.demo.shiro.entity.Permission;
import com.demo.shiro.entity.Role;
import com.demo.shiro.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


/**
 * @author huanghao
 * date 2020-11-13
 */
@Service
public class LoginService {

    public User findUserByName(String userName){
        User user=new User();
        user.setName("user1");
        user.setId(IdUtil.simpleUUID());
        String pwd = DigestUtil.md5Hex("admin");
        user.setPassword(pwd);

        Set<Role> roles=new HashSet<>();
        //创建角色
        Role role1=new Role();
        role1.setId(IdUtil.simpleUUID());
        role1.setRoleName("系统管理员");
        //创建权限
        Set<Permission> ps=new HashSet<>();
        Permission p=new Permission();
        p.setId(IdUtil.simpleUUID());
        p.setPermissionName("所有");
        ps.add(p);
        //角色添加权限
        role1.setPermissions(ps);
        roles.add(role1);
        //设置角色
        user.setRoles(roles);
        return user;
    }
}

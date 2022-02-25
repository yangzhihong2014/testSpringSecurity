package com.example.testSpringSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Intellij IDEA.
 * User:  zhi13
 * Date:  2022/2/24
 *
 * 路由控制 根据角色
 */
@Controller
public class RouterControllerByRole {

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping({"/toLogin"})
    public String toLogin(){
        return "views/login";
    }

    @RequestMapping({"/level1/{id}"})
    @PreAuthorize("hasAnyRole('ROLE_super')")
    public String level1(@PathVariable("id") int id){
        return "views/level1/"+id;
    }

    @RequestMapping({"/level2/{id}"})
    @PreAuthorize("hasAnyRole('ROLE_super')")
    public String level2(@PathVariable("id") int id){
        return "views/level2/"+id;
    }

    @RequestMapping({"/level3/{id}"})
    @PreAuthorize("hasAnyRole('ROLE_super','ROLE_normal')")
    public String level3(@PathVariable("id") int id){
        return "views/level3/"+id;
    }

}
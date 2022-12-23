package com.sam._Code_04_web_project.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping({"/master"})
//    @PreAuthorize("hasRole('User')")
    public String forUserew(){
        return "woh its accessible master";
    }

    @GetMapping({"/masterdummy2"})
    @PreAuthorize("hasRole('Admin')")
    public String forUserw(){
        return "woh its not accessible";
    }

}

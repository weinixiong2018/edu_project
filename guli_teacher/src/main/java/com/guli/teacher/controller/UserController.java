package com.guli.teacher.controller;

import com.guli.common.result.Result;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {

    @PostMapping("/login")
    public Result login() {

        return Result.ok().data("token","admin");
    }

    @GetMapping("/info")
    public Result getInfo() {

        return Result.ok().data("roles","[\"admin\"]")
                .data("name","admin")
                .data("avatar","https://wpimg.wallstcn.com");

    }

//    @PostMapping("/logout")
//    public String logout() {
//        return "/";
//    }
}

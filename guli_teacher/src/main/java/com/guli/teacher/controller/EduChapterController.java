package com.guli.teacher.controller;

import com.guli.common.result.Result;
import com.guli.teacher.service.EduChapterService;
import com.guli.teacher.utils.entityutils.OneChapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    EduChapterService eduChapterService;

    @GetMapping("/getChapter/{id}")
    public Result getChapter(@PathVariable String id) {


        List<OneChapter> list = eduChapterService.getChapter(id);

        if(list == null) {
            return Result.error().message("获取失败，请重试");
        }

        return Result.ok().data("list",list);
    }
}

package com.guli.teacher.controller;

import com.guli.common.result.Result;
import com.guli.teacher.service.EduCourseService;
import com.guli.teacher.utils.entityutils.CourseAndDescription;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@CrossOrigin
@ApiModel("课程详细信息")
public class EduCourseController {

    @Autowired
    EduCourseService eduCourseService;

    @PostMapping("/save")
    public Result saveCourseAndDescription(CourseAndDescription courseAndDescription) {

        try {
            String courseId = eduCourseService.saveCourseAndDescription(courseAndDescription);
            return Result.ok().data("courseId",courseId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().message("保存失败！");
        }
    }
}

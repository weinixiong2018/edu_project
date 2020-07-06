package com.guli.teacher.controller;

import com.guli.common.result.Result;
import com.guli.teacher.entity.EduCourse;
import com.guli.teacher.service.EduCourseService;
import com.guli.teacher.utils.entityutils.CourseAndDescription;
import com.guli.teacher.vo.SearchCourseVo;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
@ApiModel("课程详细信息")
public class EduCourseController {

    @Autowired
    EduCourseService eduCourseService;

    @PostMapping("/save")
    public Result saveCourseAndDescription(@RequestBody CourseAndDescription courseAndDescription) {

        try {
            String courseId = eduCourseService.saveCourseAndDescription(courseAndDescription);
            return Result.ok().data("courseId", courseId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().message("保存失败！");
        }
    }

    @GetMapping("/getCourseById/{id}")
    public Result getCourseById(@PathVariable String id) {
        List<CourseAndDescription> list = eduCourseService.getCourseById(id);
        if (list == null) {
            return Result.error().message("获取失败！");
        }

        return Result.ok().data("list", list);
    }

    @PostMapping("/updateCourseById")
    public Result updateCourseById(@RequestBody CourseAndDescription courseAndDescription) {
        String resultId = eduCourseService.updateCourseById(courseAndDescription);
        if (resultId == null) {
            return Result.error().message("修改失败!");
        }
        return Result.ok().data("resultId", resultId);
    }

    @PostMapping("/getCourseInfo/{page}/{limit}")
    public Result getCourseInfoAndSearchCourse(@PathVariable int page,
                                               @PathVariable int limit,
                                               @RequestBody SearchCourseVo searchCourseVo) {
        List<EduCourse> list = eduCourseService.getCourseInfoAndSearchCourse(page, limit, searchCourseVo);

        Long total = eduCourseService.getTotal(searchCourseVo);

        if (list == null) {
            return Result.error().message("查询失败");
        }

        return Result.ok().data("list", list).data("total", total);

    }

    @DeleteMapping("/deleteCourseById/{id}")
    public Result deleteCourseById(@PathVariable String id) {

        boolean result = eduCourseService.deleteCourseById(id);
        if (result) {
            return Result.ok().message("删除成功");
        } else {
            return Result.error().message("删除失败");
        }
    }
}

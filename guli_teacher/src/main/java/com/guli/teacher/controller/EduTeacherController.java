package com.guli.teacher.controller;

import com.guli.common.result.Result;
import com.guli.teacher.entity.EduTeacher;
import com.guli.teacher.service.EduTeacherService;
import com.guli.teacher.vo.AddTeacherVo;
import com.guli.teacher.vo.SearchObjVo;
import com.guli.teacher.vo.SearchTeacherVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiModel(value = "教师页面")
@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    EduTeacherService teacherService;

    @ApiOperation(value = "获取教师列表")
    @GetMapping("/getTeacherList")
    public Result getTeacherList() {

        List<EduTeacher> list = teacherService.getTeacherList();
        return Result.ok().data("list", list);

    }

    @ApiOperation(value = "删除教师")
    @DeleteMapping("/removeById/{id}")
    public Result removeById(@PathVariable(value = "id") String id) {

        Long i = teacherService.removeById(id);

        if (i == 1) {
            return Result.ok().message("删除成功");
        }

        return Result.error().message("删除失败");

    }

    @ApiOperation(value = "增加教师")
    @PostMapping("/addTeacher")
    public Result addTeacher(@RequestBody AddTeacherVo teacherVo) {

        Long i = teacherService.insertTeacher(teacherVo);

        if (i == 0) {
            return Result.error().message("增加教师失败！");
        }
        return Result.ok().message("增加教师成功");

    }

    @ApiOperation(value = "修改教师-数据回显")
    @GetMapping("/toUpdateTeacher/{id}")
    public Result toUpdateTeacher(@PathVariable(value = "id") String id) {

        List<EduTeacher> list = teacherService.getTeacherById(id);

        if (list == null) {
            return Result.error().message("获取数据失败！");
        }
        return Result.ok().data("list", list);

    }

    @ApiOperation(value = "修改教师")
    @PutMapping("/updateTeacher/{id}")
    public Result updateTeacher(@RequestBody AddTeacherVo teacherVo,@PathVariable String id) {

        Long i = teacherService.updateTeacher(teacherVo, id);

        if (i == 0) {
            return Result.error().message("修改教师失败");
        }

        return Result.ok().message("修改教师成功");

    }

    @ApiOperation(value = "分页查询教师")
    @PostMapping("/selectTeacherByPage/{page}/{limit}")
    public Result selectTeacherByPage(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit,@RequestBody SearchObjVo searchObjVo) {

        SearchTeacherVo searchTeacherVo = new SearchTeacherVo();
        BeanUtils.copyProperties(searchObjVo,searchTeacherVo);
        searchTeacherVo.setPage(page);
        searchTeacherVo.setLimit(limit);

        List<EduTeacher> list = teacherService.selectTeacherByPage(searchTeacherVo);

        Long total = teacherService.getTotal(searchTeacherVo);

        if(list == null) {
            return Result.error().message("查询失败");
        }

        return Result.ok().data("list", list).data("total",total);

    }

}

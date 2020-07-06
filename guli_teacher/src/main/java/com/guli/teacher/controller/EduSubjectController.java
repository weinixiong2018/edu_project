package com.guli.teacher.controller;

import com.guli.common.result.Result;
import com.guli.teacher.entity.EduSubject;
import com.guli.teacher.service.EduSubjectService;
import com.guli.teacher.utils.entityutils.OneClassSubject;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


@RestController
@ApiModel("课程")
@RequestMapping("/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    @PostMapping("/import")
    public Result importExl(MultipartFile file) {
        List<String> errorMessage = subjectService.importExl(file);
        if (errorMessage.size() == 0) {
            return Result.ok().message("导入成功");
        } else {
            return Result.error().data("message", errorMessage);
        }
    }

    @GetMapping("/list")
    public Result getSubjectList() {

        List<OneClassSubject> list = subjectService.getSubjectList();

        if(list.isEmpty()) {
            return Result.error().message("获取失败，请重新添加课程");
        }

        return Result.ok().data("subjectList",list);
    }

    @PostMapping("/appendOneLevel")
     public Result appendOneLevel(@RequestBody EduSubject eduSubject) {
        int i = subjectService.appendSubject(eduSubject);
        if(i == 1) {
            return Result.ok().message("添加成功");
        }
        return Result.error().message("已存在该课程，请重新确认");
    }

//    @PostMapping("/appendTwoLevel/{id}")
//    public Result appendTwoLevel(@PathVariable int id,@RequestBody EduSubject eduSubject) {
//        int i = subjectService.appendTwoLevel(id,eduSubject);
//        if(i == 1) {
//            return Result.ok().message("添加成功");
//        }
//        return Result.error().message("请重试！");
//    }

    @DeleteMapping("/delete/{id}")
    public Result deleteSubject(@PathVariable String id) {
        int i = subjectService.deleteSubject(id);
        if(i == 1) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("请重试！");
    }

}

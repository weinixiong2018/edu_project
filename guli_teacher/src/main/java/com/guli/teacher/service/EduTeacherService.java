package com.guli.teacher.service;

import com.guli.teacher.entity.EduTeacher;
import com.guli.teacher.utils.Page;
import com.guli.teacher.vo.AddTeacherVo;
import com.guli.teacher.vo.SearchTeacherVo;

import java.util.List;

public interface EduTeacherService {

    List<EduTeacher> getTeacherList();

    Long removeById(String id);

    Long insertTeacher(AddTeacherVo teacherVo);

    List<EduTeacher> getTeacherById(String id);

    Long updateTeacher(AddTeacherVo teacherVo,String id);

    List<EduTeacher> selectTeacherByPage(SearchTeacherVo searchTeacherVo);

    Long getTotal(SearchTeacherVo searchTeacherVo);
}

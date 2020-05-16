package com.guli.teacher.mapper;

import com.guli.teacher.entity.EduTeacher;
import com.guli.teacher.vo.SearchTeacherVo;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EduTeacherMapper {

    List<EduTeacher> getTeacherList();

    Long removeById(String id);

    Long insertTeacher(@Param("teacher") EduTeacher teacher);

    List<EduTeacher> getTeacherById(String id);

    Long updateTeacher(@Param("teacher") EduTeacher teacher);

    List<EduTeacher> selectTeacherByPage(@Param("searchTeacherVo") SearchTeacherVo searchTeacherVo);

    Long getTotal(@Param("searchTeacherVo") SearchTeacherVo searchTeacherVo);
}

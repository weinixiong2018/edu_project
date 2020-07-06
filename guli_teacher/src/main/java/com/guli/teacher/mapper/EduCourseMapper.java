package com.guli.teacher.mapper;

import com.guli.teacher.entity.EduCourse;
import com.guli.teacher.vo.CourseSearchVo;
import com.guli.teacher.vo.SearchCourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EduCourseMapper {
    int insertCourse(@Param("eduCourse") EduCourse eduCourse);

    EduCourse getCourseById(String id);

    int updateCourse(@Param("eduCourse") EduCourse eduCourse);

    List<EduCourse> getCourseInfo(@Param("eduCourse") CourseSearchVo eduCourse);

    Long getTotal(@Param("eduCourse") SearchCourseVo searchCourseVo);

    int deleteCourseById(String id);
}

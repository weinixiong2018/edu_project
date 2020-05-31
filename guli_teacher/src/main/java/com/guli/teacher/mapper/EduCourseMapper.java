package com.guli.teacher.mapper;

import com.guli.teacher.entity.EduCourse;
import org.apache.ibatis.annotations.Param;

public interface EduCourseMapper {
    int insertCourse(@Param("eduCourse") EduCourse eduCourse);
}

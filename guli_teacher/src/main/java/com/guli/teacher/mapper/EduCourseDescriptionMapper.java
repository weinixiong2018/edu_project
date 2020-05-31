package com.guli.teacher.mapper;

import com.guli.teacher.entity.EduCourseDescription;
import org.apache.ibatis.annotations.Param;

public interface EduCourseDescriptionMapper {
    int insertCourseDescription(@Param("eduCourseDescription") EduCourseDescription eduCourseDescription);
}

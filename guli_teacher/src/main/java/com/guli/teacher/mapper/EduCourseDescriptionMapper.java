package com.guli.teacher.mapper;

import com.guli.teacher.entity.EduCourseDescription;
import org.apache.ibatis.annotations.Param;

public interface EduCourseDescriptionMapper {
    int insertCourseDescription(@Param("eduCourseDescription") EduCourseDescription eduCourseDescription);

    EduCourseDescription getDescriptionById(String id);

    int updateDescription(@Param("eduCourseDescription") EduCourseDescription eduCourseDescription);

    EduCourseDescription getDescriptionInfo();

    Integer deleteCourseById(String id);
}

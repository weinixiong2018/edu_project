package com.guli.teacher.service;

import com.guli.teacher.entity.EduCourseDescription;

public interface EduCourseDescriptionService {
    int insertCourseDescription(EduCourseDescription eduCourseDescription);

    EduCourseDescription getDescriptionById(String id);

    int updateDescription(EduCourseDescription eduCourseDescription);

    boolean deleteCourseById(String id);
}

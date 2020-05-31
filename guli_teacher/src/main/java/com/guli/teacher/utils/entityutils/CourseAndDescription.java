package com.guli.teacher.utils.entityutils;

import com.guli.teacher.entity.EduCourse;
import com.guli.teacher.entity.EduCourseDescription;
import lombok.Data;

@Data
public class CourseAndDescription {

    private EduCourse eduCourse;
    private EduCourseDescription eduCourseDescription;
}

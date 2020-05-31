package com.guli.teacher.service.impl;

import com.guli.teacher.exp.EduException;
import com.guli.teacher.mapper.EduCourseMapper;
import com.guli.teacher.service.EduCourseDescriptionService;
import com.guli.teacher.service.EduCourseService;
import com.guli.teacher.utils.entityutils.CourseAndDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EduCourseServiceImpl implements EduCourseService {

    @Autowired
    EduCourseMapper eduCourseMapper;

    @Autowired
    EduCourseDescriptionService eduCourseDescriptionService;

    @Override
    public String saveCourseAndDescription(CourseAndDescription courseAndDescription) {
        //将新增的EduCourse插入表edu_course中，返回插入条数（1）
        int i = eduCourseMapper.insertCourse(courseAndDescription.getEduCourse());
        if(i <= 0) {
            throw new EduException(20001,"添加课程失败");
        }
        String courseId = courseAndDescription.getEduCourse().getId();
        courseAndDescription.getEduCourseDescription().setId(courseId);
        int j = eduCourseDescriptionService.insertCourseDescription(courseAndDescription.getEduCourseDescription());
        if(j <= 0) {
            throw new EduException(20001,"添加描述失败");
        }
        return courseId;
    }
}

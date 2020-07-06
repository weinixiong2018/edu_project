package com.guli.teacher.service;

import com.guli.teacher.entity.EduCourse;
import com.guli.teacher.utils.entityutils.CourseAndDescription;
import com.guli.teacher.vo.SearchCourseVo;

import java.util.List;

public interface EduCourseService {
    String saveCourseAndDescription(CourseAndDescription courseAndDescription);

    List<CourseAndDescription> getCourseById(String id);

    String updateCourseById(CourseAndDescription courseAndDescription);

    List<EduCourse> getCourseInfoAndSearchCourse(int page, int limit, SearchCourseVo searchCourseVo);

    Long getTotal(SearchCourseVo searchCourseVo);

    boolean deleteCourseById(String id);
}

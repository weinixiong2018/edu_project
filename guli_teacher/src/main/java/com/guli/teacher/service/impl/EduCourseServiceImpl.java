package com.guli.teacher.service.impl;

import com.guli.teacher.entity.EduCourse;
import com.guli.teacher.entity.EduCourseDescription;
import com.guli.teacher.exp.EduException;
import com.guli.teacher.mapper.EduCourseMapper;
import com.guli.teacher.service.EduCourseDescriptionService;
import com.guli.teacher.service.EduCourseService;
import com.guli.teacher.utils.entityutils.CourseAndDescription;
import com.guli.teacher.vo.CourseSearchVo;
import com.guli.teacher.vo.SearchCourseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class EduCourseServiceImpl implements EduCourseService {

    @Autowired
    EduCourseMapper eduCourseMapper;

    @Autowired
    EduCourseDescriptionService eduCourseDescriptionService;

    @Override
    public String saveCourseAndDescription(CourseAndDescription courseAndDescription) {
        //将新增的EduCourse插入表edu_course中，返回插入条数（1）
        //log.info("courseId:{}",courseAndDescription.getEduCourse().getId());
        if (courseAndDescription.getEduCourse().getId() == null) {
            String uuId = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
            courseAndDescription.getEduCourse().setId(uuId);
        }
        int i = eduCourseMapper.insertCourse(courseAndDescription.getEduCourse());
        if (i <= 0) {
            throw new EduException(20001, "添加课程失败");
        }
        String courseId = courseAndDescription.getEduCourse().getId();
        courseAndDescription.getEduCourseDescription().setId(courseId);
        int j = eduCourseDescriptionService.insertCourseDescription(courseAndDescription.getEduCourseDescription());
        if (j <= 0) {
            throw new EduException(20001, "添加描述失败");
        }
        return courseId;
    }

    @Override
    public List<CourseAndDescription> getCourseById(String id) {
        EduCourse eduCourse = eduCourseMapper.getCourseById(id);
        EduCourseDescription eduCourseDescription = eduCourseDescriptionService.getDescriptionById(id);
        if (eduCourse == null && eduCourseDescription == null) {
            return null;
        }
        List<CourseAndDescription> list = new ArrayList<>();
        CourseAndDescription courseAndDescription = new CourseAndDescription();
        courseAndDescription.setEduCourse(eduCourse);
        courseAndDescription.setEduCourseDescription(eduCourseDescription);
        list.add(courseAndDescription);
        return list;
    }

    @Override
    public String updateCourseById(CourseAndDescription courseAndDescription) {
        //由于前端传过来的请求体无id属性，所以需要将传入的id赋值给实体对象
        int a = eduCourseMapper.updateCourse(courseAndDescription.getEduCourse());
        int b = eduCourseDescriptionService.updateDescription(courseAndDescription.getEduCourseDescription());

        if (a == 0 || b == 0) {
            return null;
        }

        return courseAndDescription.getEduCourse().getId();
    }


    @Override
    public List<EduCourse> getCourseInfoAndSearchCourse(int page, int limit, SearchCourseVo searchCourseVo) {

        long thisPage = (page - 1) * limit;
        CourseSearchVo courseSearchVo = new CourseSearchVo();
        BeanUtils.copyProperties(searchCourseVo, courseSearchVo);
        courseSearchVo.setLimit(limit);
        courseSearchVo.setPage(thisPage);

        List<EduCourse> eduCourseLit = eduCourseMapper.getCourseInfo(courseSearchVo);

        return eduCourseLit;
    }

    @Override
    public Long getTotal(SearchCourseVo searchCourseVo) {
        Long total = eduCourseMapper.getTotal(searchCourseVo);
        return total;
    }

    @Override
    public boolean deleteCourseById(String id) {


        //删除课程描述
        boolean b = eduCourseDescriptionService.deleteCourseById(id);
        if (!b) {// 如果描述没有删除成功直接返回
            return false;
        }
        Integer result = eduCourseMapper.deleteCourseById(id);

        return result == 1;
    }
}

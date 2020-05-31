package com.guli.teacher.service.impl;

import com.guli.teacher.entity.EduCourseDescription;
import com.guli.teacher.mapper.EduCourseDescriptionMapper;
import com.guli.teacher.service.EduCourseDescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EduCourseDescriptionServiceImpl implements EduCourseDescriptionService {

    @Autowired
    EduCourseDescriptionMapper eduCourseDescriptionMapper;

    @Override
    public int insertCourseDescription(EduCourseDescription eduCourseDescription) {
        //log.info("eduCourseDescription.id={}",eduCourseDescription.getId());
        int i = eduCourseDescriptionMapper.insertCourseDescription(eduCourseDescription);
        //log.info("i={}",i);
        return i;
    }
}

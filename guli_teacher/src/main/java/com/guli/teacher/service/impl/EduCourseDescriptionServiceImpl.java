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

    @Override
    public EduCourseDescription getDescriptionById(String id) {
        EduCourseDescription eduCourseDescription = eduCourseDescriptionMapper.getDescriptionById(id);
        if(eduCourseDescription == null) {
            return null;
        }
        return eduCourseDescription;
    }

    @Override
    public int updateDescription(EduCourseDescription eduCourseDescription) {
        int result = eduCourseDescriptionMapper.updateDescription(eduCourseDescription);
        if(result == 0) {
            return 0;
        }
        return result;
    }

    @Override
    public boolean deleteCourseById(String id) {
        Integer result = eduCourseDescriptionMapper.deleteCourseById(id);
        return result == 1;
    }
}

package com.guli.teacher.mapper;

import com.guli.teacher.entity.EduSubject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EduSubjectMapper {
    List<EduSubject> getSubjectTitle();

    String insertEduSubject(@Param("eduSubject") EduSubject eduSubject);

    int deleteSubject(String id);

    int appendSubject(@Param("eduSubject") EduSubject eduSubject);

//    int appendTwoLevel(@Param("id") int id,@Param("eduSubject") EduSubject eduSubject);
}

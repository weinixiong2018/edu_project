package com.guli.teacher.service;

import com.guli.teacher.entity.EduSubject;
import com.guli.teacher.utils.entityutils.OneClassSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EduSubjectService {
    List<String> importExl(MultipartFile file);

    List<OneClassSubject> getSubjectList();

    int deleteSubject(int id);

    int appendSubject(EduSubject eduSubject);

    //int appendTwoLevel(int id, EduSubject eduSubject);
}

package com.guli.teacher.mapper;

import com.guli.teacher.entity.EduChapter;

import java.util.List;

public interface EduChapterMapper {


    List<EduChapter> getChapter(String id);
}

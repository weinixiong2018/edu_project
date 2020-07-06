package com.guli.teacher.service;

import com.guli.teacher.utils.entityutils.OneChapter;

import java.util.List;

public interface EduChapterService {

    List<OneChapter> getChapter(String id);
}

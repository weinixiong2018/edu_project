package com.guli.teacher.service.impl;

import com.guli.teacher.entity.EduChapter;
import com.guli.teacher.mapper.EduChapterMapper;
import com.guli.teacher.service.EduChapterService;
import com.guli.teacher.service.EduVideoService;
import com.guli.teacher.utils.entityutils.OneChapter;
import com.guli.teacher.utils.entityutils.TwoVideo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EduChapterServiceImpl implements EduChapterService {

    @Autowired
    EduChapterMapper eduChapterMapper;

    @Autowired
    EduVideoService eduVideoService;

    @Override
    public List<OneChapter> getChapter(String id) {

        List<OneChapter> oneChapters = new ArrayList<>();

        List<EduChapter> eduChapters = eduChapterMapper.getChapter(id);

        for(EduChapter eduChapter : eduChapters) {

            OneChapter oneChapter = new OneChapter();

            BeanUtils.copyProperties(eduChapter,oneChapter);

            List<TwoVideo> twoVideos = eduVideoService.getVideo(eduChapter.getId());

            oneChapter.setChildren(twoVideos);

            oneChapters.add(oneChapter);
        }

        return oneChapters;
    }
}

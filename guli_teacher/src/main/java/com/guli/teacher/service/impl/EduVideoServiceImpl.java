package com.guli.teacher.service.impl;

import com.guli.teacher.entity.EduVideo;
import com.guli.teacher.mapper.EduVideoMapper;
import com.guli.teacher.service.EduVideoService;
import com.guli.teacher.utils.entityutils.TwoVideo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EduVideoServiceImpl implements EduVideoService {

    @Autowired
    EduVideoMapper eduVideoMapper;

    @Override
    public List<TwoVideo> getVideo(String id) {

        List<EduVideo> eduVideos = eduVideoMapper.getVideo(id);
        List<TwoVideo> twoVideos = new ArrayList<>();

        for(EduVideo eduVideo : eduVideos) {
            TwoVideo twoVideo = new TwoVideo();
            BeanUtils.copyProperties(eduVideo,twoVideo);
            twoVideos.add(twoVideo);
        }


        return twoVideos;
    }
}

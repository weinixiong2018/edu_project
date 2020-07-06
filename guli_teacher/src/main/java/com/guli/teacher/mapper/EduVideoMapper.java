package com.guli.teacher.mapper;

import com.guli.teacher.entity.EduVideo;

import java.util.List;

public interface EduVideoMapper {
    List<EduVideo> getVideo(String id);
}

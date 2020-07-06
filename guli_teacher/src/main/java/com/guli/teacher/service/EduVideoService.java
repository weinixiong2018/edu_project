package com.guli.teacher.service;

import com.guli.teacher.utils.entityutils.TwoVideo;

import java.util.List;

public interface EduVideoService {
    List<TwoVideo> getVideo(String id);
}

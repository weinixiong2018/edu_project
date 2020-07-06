package com.guli.teacher.vo;

import lombok.Data;

@Data
public class SearchCourseVo {
    private String subjectParentId;
    private String subjectId;
    private String title;
    private String teacherId;
}

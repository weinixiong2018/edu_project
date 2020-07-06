package com.guli.teacher.vo;

import lombok.Data;

@Data
public class CourseSearchVo {

    private String subjectParentId;
    private String subjectId;
    private String title;
    private String teacherId;
    private long limit;
    private long page;
}

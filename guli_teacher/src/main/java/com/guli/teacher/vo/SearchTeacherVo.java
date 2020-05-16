package com.guli.teacher.vo;

import lombok.Data;

@Data
public class SearchTeacherVo {

    private String name;
    private Long level;
    private String gmtCreate;
    private String gmtModified;
    private long page;
    private long limit;

}

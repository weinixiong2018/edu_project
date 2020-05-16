package com.guli.teacher.vo;

import lombok.Data;


@Data
public class AddTeacherVo {

    private String name;
    private String intro;
    private String career;
    private long level;
    private String avatar;
    private long sort;
    private long isDeleted = 0;

}

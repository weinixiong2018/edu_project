package com.guli.teacher.entity;


import lombok.Data;

import java.util.Date;

@Data
public class EduTeacher {

  private String id;
  private String name;
  private String intro;
  private String career;
  private long level;
  private String avatar;
  private long sort;
  private long isDeleted;
  private Date gmtCreate;
  private Date gmtModified;

}

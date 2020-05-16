package com.guli.teacher.entity;


import lombok.Data;

import java.util.Date;

@Data
public class EduChapter {

  private String id;
  private String courseId;
  private String title;
  private long sort;
  private Date gmtCreate;
  private Date gmtModified;


}

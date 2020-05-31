package com.guli.teacher.entity;


import lombok.Data;

import java.util.Date;

@Data
public class EduSubject {

  private int id;
  private String title;
  private String parentId;
  private long sort=0;
  private Date gmtCreate;
  private Date gmtModified;


}

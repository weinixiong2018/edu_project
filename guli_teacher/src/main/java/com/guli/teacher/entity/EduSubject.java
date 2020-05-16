package com.guli.teacher.entity;


import lombok.Data;

import java.util.Date;

@Data
public class EduSubject {

  private String id;
  private String title;
  private String parentId;
  private long sort;
  private Date gmtCreate;
  private Date gmtModified;


}

package com.guli.teacher.entity;


import lombok.Data;

import java.util.Date;

@Data
public class EduCourseDescription {

  private String id;
  private String description;
  private Date gmtCreate;
  private Date gmtModified;

}

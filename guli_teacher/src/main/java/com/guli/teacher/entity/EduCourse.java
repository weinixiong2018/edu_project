package com.guli.teacher.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EduCourse {

  private String id;
  private String teacherId;
  private String subjectParentId;
  private String subjectId;
  private String title;
  private double price;
  private long lessonNum;
  private String cover;
  private long buyCount = 0;
  private long viewCount = 0;
  private long version = 1;
  private String status = "0";
  private Date gmtCreate;
  private Date gmtModified;

}

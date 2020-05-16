package com.guli.teacher.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EduCourse {

  private String id;
  private String teacherId;
  private String subjectId;
  private String title;
  private double price;
  private long lessonNum;
  private String cover;
  private long buyCount;
  private long viewCount;
  private long version;
  private String status;
  private Date gmtCreate;
  private Date gmtModified;

}

package com.guli.teacher.entity;

import lombok.Data;

@Data
public class EduVideo {

  private String id;
  private String courseId;
  private String chapterId;
  private String title;
  private long sort;
  private long playCount;
  private long isFree;
  private String videoSourceId;
  private double duration;
  private String status;
  private long size;
  private long version;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;

}

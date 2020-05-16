package com.guli.teacher.entity;


import lombok.Data;

import java.util.Date;

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
  private Date gmtCreate;
  private Date gmtModified;


}

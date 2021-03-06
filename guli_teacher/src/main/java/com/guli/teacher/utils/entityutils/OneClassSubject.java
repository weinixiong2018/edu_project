package com.guli.teacher.utils.entityutils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OneClassSubject {

    private String id;
    private String title;
    private List<TwoClassSubject> twoClassSubjects = new ArrayList<>();

}

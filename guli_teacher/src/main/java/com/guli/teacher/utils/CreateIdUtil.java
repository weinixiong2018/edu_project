package com.guli.teacher.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreateIdUtil {

    public static String getResultId() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");


        String resultId = sdf.format(new Date());

        return resultId;
    }
}

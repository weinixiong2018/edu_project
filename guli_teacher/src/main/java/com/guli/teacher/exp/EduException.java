package com.guli.teacher.exp;

import com.guli.common.enums.ResultEnum;
import lombok.Data;

@Data
public class EduException extends RuntimeException{

    private int code;
    private String message;

    public EduException() {
    }

    public EduException(int code,String message) {
        this.code = code;
        this.message = message;
    }
}

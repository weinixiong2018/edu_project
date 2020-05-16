package com.guli.teacher;

import com.guli.teacher.entity.EduTeacher;
import com.guli.teacher.service.impl.EduTeacherServiceImpl;
import com.guli.teacher.utils.CreateIdUtil;
import com.guli.teacher.utils.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GuliTeacherApplicationTests {

    @Autowired
    EduTeacherServiceImpl teacherServiceImpl;

    @Test
    public void test01() {
        List<EduTeacher> list = teacherServiceImpl.getTeacherList();
        System.out.println(list);
    }

    @Test
    public void test02() {
        String id = CreateIdUtil.getResultId();
        System.out.println(id);
    }

    @Test
    public  void test03() {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.parse("2019-02-22 22:35:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

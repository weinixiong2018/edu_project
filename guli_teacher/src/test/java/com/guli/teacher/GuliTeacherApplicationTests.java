package com.guli.teacher;

import com.guli.teacher.entity.EduTeacher;
import com.guli.teacher.service.impl.EduSubjectServiceImpl;
import com.guli.teacher.service.impl.EduTeacherServiceImpl;
import com.guli.teacher.utils.CreateIdUtil;
import com.guli.teacher.utils.Page;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GuliTeacherApplicationTests {

    @Autowired
    EduTeacherServiceImpl teacherServiceImpl;

    @Autowired
    EduSubjectServiceImpl eduSubjectService;

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
    public void test03() {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.parse("2019-02-22 22:35:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04() {

        File file = new File("C:\\Users\\HTH\\Desktop\\课程分类.xls");
        try {
            //获取文件输入流
            InputStream inputStream = new FileInputStream(file);
            //获取xls文件内容
            //创建workbook
            Workbook workbook = new HSSFWorkbook(inputStream);
            //获取sheet
            Sheet sheet = workbook.getSheetAt(0);
            //获取表的行数
            int rowNum = sheet.getLastRowNum();
            if (rowNum <= 1) {
                System.out.println("请填写数据");
            }
            for (int i = 1; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                //获取该行第一列数据
                Cell cell1 = row.getCell(0);
                if (cell1 == null) {
                    System.out.println("第" + (i + 1) + "行第一列数据为空");
                    continue;
                }
                String cellValue = cell1.getStringCellValue();
                if (StringUtils.isEmpty(cellValue)) {
                    System.out.println("第" + (i + 1) + "行第一列数据为空");
                    continue;
                }
                System.out.println(cellValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //eduSubjectService.importExl(file1);
    }
}

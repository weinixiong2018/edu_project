package com.guli.teacher.service.impl;

import com.guli.teacher.entity.EduSubject;
import com.guli.teacher.mapper.EduSubjectMapper;
import com.guli.teacher.service.EduSubjectService;
import com.guli.teacher.utils.entityutils.OneClassSubject;
import com.guli.teacher.utils.entityutils.TwoClassSubject;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EduSubjectServiceImpl implements EduSubjectService {

    @Autowired
    private EduSubjectMapper eduSubjectMapper;

    @Override
    public int appendSubject(EduSubject eduSubject) {
        List<EduSubject> lists = eduSubjectMapper.getSubjectTitle();
        int returnNumber = isEquals(eduSubject.getTitle(), lists);
        if (returnNumber == 0) {
            int i = eduSubjectMapper.appendSubject(eduSubject);
            return i;
        }
        return 0;
    }

//    @Override
//    public int appendTwoLevel(int id,EduSubject eduSubject) {
//
//        int i = eduSubjectMapper.appendTwoLevel(id,eduSubject);
//        return i;
//    }

    @Override
    public int deleteSubject(int id) {

        int i = eduSubjectMapper.deleteSubject(id);
        return i;
    }

    @Override
    public List<OneClassSubject> getSubjectList() {
        List<OneClassSubject> oneClassSubjectList = new ArrayList<>();

        List<EduSubject> lists = eduSubjectMapper.getSubjectTitle();
        //log.info("lists={}",lists);
        int size = lists.size();
        for (int i = 0; i < size; i++) {
            List<TwoClassSubject> twoClassSubjectList = new ArrayList<>();
            //log.info("lists.get(" + i + ")={}", lists.get(i));
            //一级目录
            if ("0".equals(lists.get(i).getParentId())) {
                OneClassSubject oneClassSubject = new OneClassSubject();
                BeanUtils.copyProperties(lists.get(i), oneClassSubject);
                //log.info("oneClassSubject={}", oneClassSubject);

                //获取二级目录
                for (int j = 0; j < size; j++) {
                    if (lists.get(i).getId() == Integer.parseInt(lists.get(j).getParentId())) {
                        TwoClassSubject twoClassSubject = new TwoClassSubject();
                        BeanUtils.copyProperties(lists.get(j), twoClassSubject);
                        twoClassSubjectList.add(twoClassSubject);
                        //log.info("twoClassSubjectList={}", twoClassSubjectList);
                    }
                }
                oneClassSubject.setTwoClassSubjects(twoClassSubjectList);
                oneClassSubjectList.add(oneClassSubject);
                //log.info("oneClassSubjectList={}", oneClassSubjectList);
            }
        }
        return oneClassSubjectList;

    }

    @Override
    public List<String> importExl(MultipartFile file) {
        List<String> msgList = new ArrayList<>();
        List<EduSubject> listFromDatabase = eduSubjectMapper.getSubjectTitle();

        try {
            //获取文件输入流
            InputStream inputStream = file.getInputStream();
            //获取xls文件内容
            //创建workbook
            Workbook workbook = new HSSFWorkbook(inputStream);
            //获取sheet
            Sheet sheet = workbook.getSheetAt(0);
            //获取表的行数
            int rowNum = sheet.getLastRowNum();
            if (rowNum <= 1) {
                msgList.add("请填写数据");
                return msgList;
            }
            for (int i = 1; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                //获取该行第一列数据
                Cell cell1 = row.getCell(0);
                if (cell1 == null) {
                    msgList.add("第" + (i + 1) + "行第一列数据为空");
                    continue;
                }
                String cellValue = cell1.getStringCellValue();
                if (StringUtils.isEmpty(cellValue)) {
                    msgList.add("第" + (i + 1) + "行第一列数据为空");
                    continue;
                }
                String pid = null;
                int returnIdOne = isEquals(cellValue, listFromDatabase);
                if (returnIdOne == 0) {
                    EduSubject eduSubject = new EduSubject();
                    eduSubject.setTitle(cellValue);
                    eduSubject.setParentId("0");
                    int id = eduSubjectMapper.insertEduSubject(eduSubject);
                    pid = String.valueOf(id);
                } else {
                    pid = String.valueOf(returnIdOne);
                }

                Cell cell2 = row.getCell(1);
                if (cell2 == null) {
                    msgList.add("第" + (i + 1) + "行第二列数据为空");
                    continue;
                }
                String cellValue2 = cell2.getStringCellValue();
                if (StringUtils.isEmpty(cellValue2)) {
                    msgList.add("第" + (i + 1) + "行第二列数据为空");
                    continue;
                }
                int returnIdTwo = isEquals(cellValue2, listFromDatabase);
                if (returnIdTwo == 0) {
                    EduSubject eduSubject = new EduSubject();
                    eduSubject.setTitle(cellValue2);
                    eduSubject.setParentId(pid);
                    eduSubjectMapper.insertEduSubject(eduSubject);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return msgList;
    }

    private int isEquals(String str, List<EduSubject> list) {
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i).getTitle())) {
                return list.get(i).getId();
            }
        }
        return 0;
    }
}

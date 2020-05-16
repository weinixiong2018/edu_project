package com.guli.teacher.service.impl;

import com.guli.teacher.entity.EduTeacher;
import com.guli.teacher.mapper.EduTeacherMapper;
import com.guli.teacher.service.EduTeacherService;
import com.guli.teacher.utils.CreateIdUtil;
import com.guli.teacher.utils.Page;
import com.guli.teacher.vo.AddTeacherVo;
import com.guli.teacher.vo.SearchTeacherVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EduTeacherServiceImpl implements EduTeacherService {

    @Autowired
    EduTeacherMapper teacherMapper;

    @Override
    public List<EduTeacher> getTeacherList() {
        List<EduTeacher> list = teacherMapper.getTeacherList();
        return list;
    }

    @Override
    public Long removeById(String id) {
        Long i = teacherMapper.removeById(id);
        return i;
    }

    @Override
    public Long insertTeacher(AddTeacherVo teacherVo) {

        EduTeacher teacher = new EduTeacher();
        BeanUtils.copyProperties(teacherVo, teacher);

        String id = CreateIdUtil.getResultId();

        teacher.setId(id);

        Long i = teacherMapper.insertTeacher(teacher);

        return i;
    }

    @Override
    public List<EduTeacher> getTeacherById(String id) {
        List<EduTeacher> list = teacherMapper.getTeacherById(id);
        return list;
    }

    @Override
    public Long updateTeacher(AddTeacherVo teacherVo, String id) {

        EduTeacher teacher = new EduTeacher();

        BeanUtils.copyProperties(teacherVo, teacher);

        teacher.setId(id);

        Long i = teacherMapper.updateTeacher(teacher);

        return i;
    }

    @Override
    public List<EduTeacher> selectTeacherByPage(SearchTeacherVo searchTeacherVo) {
        Long pageNo = (searchTeacherVo.getPage() - 1) * searchTeacherVo.getLimit();
        searchTeacherVo.setPage(pageNo);

        List<EduTeacher> teachers = teacherMapper.selectTeacherByPage(searchTeacherVo);
        return teachers;
    }

    @Override
    public Long getTotal(SearchTeacherVo searchTeacherVo) {
        Long total = teacherMapper.getTotal(searchTeacherVo);
        return total;
    }
}

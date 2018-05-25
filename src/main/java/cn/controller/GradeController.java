package cn.controller;

import cn.pojo.Grade;
import cn.service.GradeService;
import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GradeController {



    @Autowired
    private GradeService gradeService;


    @ResponseBody
    @RequestMapping(value = "/querygrade")
    public Object gradeAll(){
        List<Grade> grades = gradeService.getGrades();
        return JSON.toJSONString(grades);
    }
}

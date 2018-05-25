package cn.controller;

import cn.pojo.Grade;
import cn.pojo.Student;
import cn.service.GradeService;
import cn.service.StudentService;
import cn.tools.Constant;
import cn.tools.ImgUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {


    @Autowired
    private  StudentService StudentService;

    @Autowired
    private GradeService gradeService;

    /*显示首页*/
    @RequestMapping(value = "/index.html")
    public String index(Model model){
        List<Grade> grades = gradeService.getGrades();
        model.addAttribute("grades", grades);
        return "index";
    }


    /*动态查询*/
    @ResponseBody
    @RequestMapping(value = "/select")
    public ModelAndView index(@RequestParam(required = false) Integer  pageIndex ,
                              @RequestParam(required = false) String  querystuName ,
                              @RequestParam(required = false) Integer  gradeId,
                              HttpServletRequest request){

        ModelAndView  mView = new ModelAndView("data");
        int pageIndex1 = pageIndex == null  ? 1 : pageIndex;

        Student stu = new Student();
        stu.setStuName(querystuName);
        stu.setStuGradeId(gradeId);

        List<Student> lists = StudentService.getStus(pageIndex1, Constant.PAGESIZE,stu);
        String oldPicPath = null;
        String newPicPath = null;
        for(int i = 0; i< lists.size(); i++){
            oldPicPath = lists.get(i).getStuPic();
            newPicPath = ImgUtil.checkImgExits(request,oldPicPath);
            lists.get(i).setStuPic(newPicPath);
        }
        PageInfo<Student> pageInfo = new PageInfo<Student>(lists);

        mView.addObject("pageInfo", pageInfo);

        return mView;
    }

   /* 删除学员*/
    @RequestMapping(value="/delete")
    @ResponseBody
    public  Object delete(String stuId){
        boolean flag = StudentService.delStuById(Integer.parseInt(stuId));
        if(flag){
            return "{\"result\":\"ok\"}";
        }else{
            return "{\"result\":\"no\"}";
        }
    }


    /*显示添加页面*/
    @RequestMapping(value = "/add.html" , method = RequestMethod.GET)
    public String addStu(){
        return "add";
    }

    /*处理添加功能*/
    @RequestMapping(value = "/addstu" , method = RequestMethod.POST)
    @ResponseBody
    public Object doaddStu(HttpServletRequest request, Student student, @RequestParam(value ="pic", required = false) MultipartFile attach ) {

        String idPicPath = null;
        //判断文件是否为空
        if (!attach.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
            String oldFileName = attach.getOriginalFilename();//原文件名
            String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀

            if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
                    || prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {//上传图片格式不正确
                String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Personal.jpg";

                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                student.setStuPic(fileName);

                try {
                    attach.transferTo(targetFile);

                } catch (IOException e) {

                    e.printStackTrace();
                }

            } else {
                return "{\"result\":\"0\",\"info\":\"上传文件格式错误\"}";
            }
        }

        boolean flag = StudentService.addStu(student);
        if(flag){
            return "{\"result\":\"1\",\"info\":\"添加成功！\"}";
        }else{
            return "{\"result\":\"2\",\"info\":\"添加失败！\"}";
        }
    }


    @RequestMapping(value = "/queryStuById")
    @ResponseBody
    public Object getStuById(HttpServletRequest request, int stuId){
        Student stu = StudentService.getStuByStuId(stuId);
        stu.setStuPic(ImgUtil.checkImgExits(request,stu.getStuPic()));
        return JSON.toJSONString(stu);
    }

    /*处理修改功能*/
    @RequestMapping(value = "/upStu" , method = RequestMethod.POST)
    @ResponseBody
    public Object doupStu(HttpServletRequest request, Student student, @RequestParam(value ="pic", required = false) MultipartFile attach ) {

        String idPicPath = null;
        //判断文件是否为空
        if (!attach.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
            String oldFileName = attach.getOriginalFilename();//原文件名
            String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀

            if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
                    || prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {//上传图片格式不正确
                String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Personal.jpg";

                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                student.setStuPic(fileName);

                try {
                    attach.transferTo(targetFile);

                } catch (IOException e) {

                    e.printStackTrace();
                }

            } else {
                return "{\"result\":\"0\",\"info\":\"上传文件格式错误\"}";
            }
        }

        boolean flag = StudentService.updateStu(student);
        if(flag){
            return "{\"result\":\"1\",\"info\":\"修改成功！\"}";
        }else{
            return "{\"result\":\"2\",\"info\":\"修改失败！\"}";
        }
    }

}

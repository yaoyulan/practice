package cn.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {
    private Integer stuId;

    private String stuName;

    private String stuSex;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
   /* @JSONField(format = "YYYY-MM-dd")*/
    private Date stuBirthday;

    private Integer stuGradeId;

    private String stuPic;

    private String gradeName;


    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public Date getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public Integer getStuGradeId() {
        return stuGradeId;
    }

    public void setStuGradeId(Integer stuGradeId) {
        this.stuGradeId = stuGradeId;
    }

    public String getStuPic() {
        return stuPic;
    }

    public void setStuPic(String stuPic) {
        this.stuPic = stuPic;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuBirthday=" + stuBirthday +
                ", stuGradeId=" + stuGradeId +
                ", stuPic='" + stuPic + '\'' +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
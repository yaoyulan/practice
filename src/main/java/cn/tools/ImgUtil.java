package cn.tools;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class ImgUtil   {

    public static String checkImgExits(javax.servlet.http.HttpServletRequest request,String picPath){
        String dir = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");

         if(picPath == null || picPath == ""){
             return "default.jpg";
         }else {
             File file = new File(dir,picPath);
             if( file.exists()){
                 return picPath;
             }else {
                 return "default.jpg";
             }
         }
    }
}

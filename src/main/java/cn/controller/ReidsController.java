package cn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReidsController {

    @Autowired
    private RedisTemplate redisTemplate ;

    @RequestMapping(value="/redisTest.html")
    public ModelAndView index(ModelAndView mv){



        redisTemplate.opsForValue().set("name","我是大美女");

        String name = redisTemplate.opsForValue().get("name").toString();

        mv.addObject("name",name);
        mv.setViewName("redisTest");

        return   mv;
    }

}

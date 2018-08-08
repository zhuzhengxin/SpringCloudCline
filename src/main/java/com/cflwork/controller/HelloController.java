package com.cflwork.controller;

import com.cflwork.service.UserService;
import com.cflwork.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("hello")
public class HelloController {

    @Resource
    private UserService userService;
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){

        return "hello word!";
    }
    @RequestMapping("/helloView")
    public String helloView(Model model){
        model.addAttribute("msg","hello");
        return "index";
    }
    /**
     *
     * @param id 用户的编号
     * @return 返回用的基本信息，对象
     */
    @RequestMapping("getInfo/{id}")
    @ResponseBody
    public User getInfo(@PathVariable("id") Integer id){
        return userService.selectByPrimaryKey(id);
    }

}

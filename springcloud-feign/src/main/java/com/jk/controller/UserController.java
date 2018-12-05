package com.jk.controller;

import com.jk.service.UserService;
import com.jk.model.User;
import feign.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/toQueryUser")
    public String toQueryUser(){
        return "test1";
    }

    @RequestMapping(value = "/queryUser")
    public String queryUser(Model model){
        List<User> list1 = userService.queryUser();
        User user=new User();
        model.addAttribute("user",user);
        model.addAttribute("list1",list1);

        return  "test1";
    }

/*    @RequestMapping(value = "/queryUser",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String,Object> queryUser(){
        List<User> userList=userService.queryUser();
        HashMap<String,Object> map= new HashMap<>();
        map.put("rows",userList);
        return  map;
    }*/

    /*@RequestMapping(value="/addUser")*/
    /*@ResponseBody*/
 /*   public  void  addUser(User user){
        userService.addUser(user);
    }*/



    @RequestMapping(value = "/addUser")
    public String addUser(User user){
      userService.addUser(user);
       // model.addAttribute("success","新增成功");
    return  "forward:" +
            "queryUser";
    }

    @RequestMapping("aa")
    @ResponseBody
    public String aa(){
        return userService.aa();
    }
}

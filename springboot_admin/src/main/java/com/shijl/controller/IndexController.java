package com.shijl.controller;


import com.shijl.bean.Account;
import com.shijl.bean.City;
import com.shijl.bean.User;
import com.shijl.service.AccountService;
import com.shijl.service.CityService;
import com.shijl.service.impl.CityServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CityServiceImpl cityService;

    @ResponseBody
    @PostMapping("/saveCity")
    public String saveCity(City city){
        cityService.saveCity(city);
        return city.toString();
    }


    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam ("id") Long id){
        City city = cityService.getById(id);
        return city;
    }


    @ResponseBody
    @GetMapping("/account")
    public Account getAccountById(@RequestParam ("id") Long id){
        Account account = accountService.getAccountById(id);
        return account;
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFormDb(){
        List<Map<String, Object>> lists = jdbcTemplate.queryForList("select * from user");
        return lists.toString();

    }

    /**
     * 登陆页
     * @return
     */
    @GetMapping({"/","/login"})
    public String intoIndexPage(){
        return "login";
    }

    /**
     * 重定向到  main  页面，避免刷新表单重复提交
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String mainPage(User user, HttpSession session, Model model){

        if(StringUtils.isNotEmpty(user.getUserName()) && StringUtils.equals("123",user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号或密码错误");
            return "login";
        }

    }

    @GetMapping("main.html")
    public String mainPage(HttpSession session,Model model){
        /*if(session.getAttribute("loginUser") != null){
            return "main";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }*/
        return "main";

    }
}

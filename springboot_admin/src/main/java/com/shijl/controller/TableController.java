package com.shijl.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shijl.bean.User;
import com.shijl.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/basic_table")
    public String basic_table() {

        return "/table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {

        List<User> users = Arrays.asList(new User("zhangsan", "1234"),
                new User("lisi", "1234"),
                new User("wangwu", "1234"));
        model.addAttribute("users", users);

        return "/table/dynamic_table";
    }

    /**
     *
     * @param id  删除的用户io
     * @param pn  当前页码
     * @param redirectAttributes  重定向参数
     * @return
     */
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable ("id") String id,
                             @RequestParam(value = "pn",defaultValue = "1") String pn,
                             RedirectAttributes redirectAttributes) {

        userService.removeById(id);
        //重定向携带参数
        redirectAttributes.addAttribute("pn",pn);
        return "redirect:/editable_table";
    }


    @GetMapping("/editable_table")
    public String editable_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        List<User> list = userService.list();
        model.addAttribute("users", list);
        //pn 当前页
        //size  每页显示几条
        Page<User> page = new Page<>(pn, 2);
        IPage<User> iPage = userService.page(page, null);
        model.addAttribute("page", iPage);
        return "/table/editable_table";
    }


    @GetMapping("/pricing_table")
    public String pricing_table() {
        return "/table/pricing_table";
    }


    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "/table/responsive_table";
    }
}

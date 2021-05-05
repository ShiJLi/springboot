package com.shijl.controller;


import com.alibaba.fastjson.JSON;
import com.shijl.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 返回树形数据结构
 */
@RestController
public class TreeFormController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/tree")
    public String treeForm() {
        //获取所有
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from student");
        List<Student> students = new ArrayList<>();
        list.stream().forEach(li->{
            Student student = new Student();
            student.setId((Integer) li.get("id"));
            student.setName((String) li.get("name"));
            student.setPno((Integer) li.get("pno"));
            students.add(student);
        });

        //定义一个集合用作最终返回的数据
        ArrayList<Student> finalList = new ArrayList<>();
        //定义一个集合存储所有的父节点
        ArrayList<Student> parentList = new ArrayList<>();
        for (Student student : students) {
            if(student.getPno() == null){
                parentList.add(student);
                finalList.add(student);
            }else {
                //  二  三级菜单
                for (Student parent : parentList) {
                    if(parent.getId().equals(student.getPno())){
                        parent.getChildList().add(student);
                    }
                }
                parentList.add(student);
            }
        }

        return JSON.toJSONString(finalList);
    }
}

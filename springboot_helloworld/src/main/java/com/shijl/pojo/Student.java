package com.shijl.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class Student implements Serializable {

    private Integer id;
    private String name;
    private Integer pno;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pno=" + pno +
                ", childList=" + childList +
                '}';
    }

    private List<Student> childList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
    }

    public List<Student> getChildList() {
        return childList;
    }

    public void setChildList(List<Student> childList) {
        this.childList = childList;
    }
}

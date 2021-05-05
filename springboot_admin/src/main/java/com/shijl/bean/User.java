package com.shijl.bean;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")
public class User {
    /**
     * @TableField(exist = false)
     *
     * 表明这个属性在表中不存在
     */
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //以下为数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

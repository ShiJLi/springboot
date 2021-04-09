package com.shijl.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "dog")
public class Dog {

    private String name;
    private String address;

    private Integer age;
    private Date birth;

}

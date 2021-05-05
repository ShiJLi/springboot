package com.shijl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shijl.bean.User;
import com.shijl.mapper.UserMapper;
import com.shijl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}

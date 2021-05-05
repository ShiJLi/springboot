package com.shijl.mapper;

import com.shijl.bean.Account;
import org.apache.ibatis.annotations.Mapper;


//@Mapper
public interface AccountMapper {

    Account getAccount(Long id);
}

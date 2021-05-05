package com.shijl.service;


import com.shijl.bean.Account;
import com.shijl.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account getAccountById(Long id){
        Account account = accountMapper.getAccount(id);
        return account;
    }
}

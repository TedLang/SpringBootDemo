package com.example.springboot.Service;

import com.example.springboot.dao.AccountMapper;
import com.example.springboot.entity.Account;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Yu
 * @Date: 2019-02-10
 * @Descripe:
 */
@Service
public class AccountService {

  @Autowired
  private AccountMapper accountMapper;

  public int add(String name, double money) {
    return accountMapper.add(name, money);
  }

  public int update(String name, double money, int id) {
    return accountMapper.update(name, money, id);
  }
  public int delete(int id) {
    return accountMapper.delete(id);
  }
  public Account findAccount(int id) {
    return accountMapper.findAccount(id);
  }
  public List<Account> findAccountList() {
    return accountMapper.findAccountList();
  }

  @Transactional
  public void transfer() throws RuntimeException
  {
    accountMapper.transfer(90,1);
    int i = 1/0;// 异常测试代码
    accountMapper.transfer(110,2);
  }
}

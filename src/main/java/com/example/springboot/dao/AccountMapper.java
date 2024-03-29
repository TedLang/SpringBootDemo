package com.example.springboot.dao;

import com.example.springboot.entity.Account;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author: Yu
 * @Date: 2019-02-10
 * @Descripe:
 */
@Mapper
public interface AccountMapper {

  @Insert("insert into account(name, money) values(#{name}, #{money}")
  int add(@Param("name") String name, @Param("money") double money);

  @Update("update account set name = #{name}, money = #{money} where id= #{id}")
  int update(@Param("name") String name, @Param("money") double money, @Param("id") int id);

  @Update("update account set money = #{money} where id = #{id}")
  int transfer(@Param("money") int money, @Param("id") int id);

  @Delete("delete from account where id= #{id}")
  int delete(int id);

  @Select("select id, name as name, money as money from account where id = #{id}")
  Account findAccount(@Param("id") int id);

  @Select("select id, name as name, money as money from account")
  List<Account> findAccountList();

}

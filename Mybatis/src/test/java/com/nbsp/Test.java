package com.nbsp;

import com.nbsp.Dao.AccountDao;
import com.nbsp.domain.Account;
import com.nbsp.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;


    @Before
    public void before(){
        //1.读取配置文件

        try {
            in = Resources.getResourceAsStream("MybatisConfig.xml");
            //2.创建 SqlSessionFactory 的构建者对象
             builder = new SqlSessionFactoryBuilder();
            //3.使用构建者创建工厂对象 SqlSessionFactory
             factory = builder.build(in);
            //4.使用 SqlSessionFactory 生产 SqlSession 对象
             session = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        try {
            in.close();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void FindAll(){
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<Account> accounts = mapper.FindAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @org.junit.Test
    public void FindByid(){
        AccountDao mapper = session.getMapper(AccountDao.class);
        Account accounts = mapper.FindById(1);
            System.out.println(accounts);
    }

    @org.junit.Test
    public void deleteById(){
        AccountDao mapper = session.getMapper(AccountDao.class);
       mapper.DeleteAccountByid(4);
    }

    @org.junit.Test
    public void insertAccounts(){
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<Account> list=new ArrayList<Account>();
        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();

        account1.setName("fff");
        account1.setMoney(77f);
        account1.setName("ggg");
        account1.setMoney(88f);
        account1.setName("hhh");
        account1.setMoney(99f);

        list.add(account1);
        list.add(account2);
        list.add(account3);
     // int num=  mapper.insertAccounts(list);
     //   System.out.println(num);
        int insert = mapper.insert(account1);
        System.out.println(insert);
    }
    @org.junit.Test
    public void FindAccountUser(){
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<AccountUser> accountUsers = mapper.FindAccountUser();
        for (AccountUser accountUser : accountUsers) {
            System.out.println(accountUser);
        }
    }


}

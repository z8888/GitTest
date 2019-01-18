package com.nbsp.Dao;

import com.nbsp.domain.Account;
import com.nbsp.domain.AccountUser;

import java.util.List;

public interface AccountDao {

    List<Account> FindAll();

    Account FindById(Integer id);

    void  DeleteAccountByid(Integer id);

    int  insertAccounts(List<Account> accounts);

    int  insert(Account accounts);

    List<AccountUser> FindAccountUser();
}

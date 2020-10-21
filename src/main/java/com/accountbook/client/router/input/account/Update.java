package com.accountbook.client.router.input.account;

import com.accountbook.domain.Account;
import com.accountbook.domain.form.AccountForm;

public interface Update {
    boolean update(Account account, AccountForm accountForm);
}

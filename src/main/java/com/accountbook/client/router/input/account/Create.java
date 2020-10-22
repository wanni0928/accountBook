package com.accountbook.client.router.input.account;

import com.accountbook.domain.form.AccountForm;

public interface Create {
    boolean save(AccountForm accountForm);
}

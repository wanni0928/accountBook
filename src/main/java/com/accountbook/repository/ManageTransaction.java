package com.accountbook.repository;

import java.sql.Connection;

public interface ManageTransaction {
    void setSessionOpen();
    void setSessionClose();
    void commit();
    Connection getConnection();
}

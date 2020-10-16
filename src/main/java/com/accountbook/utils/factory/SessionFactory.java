package com.accountbook.utils.factory;

import java.io.IOException;

public interface SessionFactory<T> {
    T getInstance() throws IOException;
}

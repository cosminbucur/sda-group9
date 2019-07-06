package com.bucur.bankingapp.export;

import com.bucur.bankingapp.model.Account;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface CustomFileWriter {

    String ACCOUNTS_DB = "C:\\dev\\sda\\bankingapp\\src\\main\\resources\\accounts-db.txt";
    Path path = Paths.get(ACCOUNTS_DB);

    void persist(Account account) throws IOException;
}

package com.bucur.bankingapp.load;

import com.bucur.bankingapp.model.Account;

import java.io.IOException;
import java.util.List;

public interface FileLoader {


    /**
     * Loads data from a file.
     * @return list of accounts
     */
    List<Account> loadData() throws IOException;
}

package com.bucur.bankingapp.load;

import com.bucur.bankingapp.model.Account;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileLoader implements FileLoader {

    // CTR + ALT + L
    @Override
    public List<Account> loadData() throws IOException {
        // read from file line by line
        String stringPath = "C:\\dev\\sda\\bankingapp\\src\\main\\resources\\accounts-db.txt";
        Path path = Paths.get(stringPath);
        List<String> accountLines = Files.readAllLines(path);

        // for each line add to list
        List<Account> accounts = new ArrayList<Account>();

        for (String accountLine : accountLines) {
            // split line by columns (comma separated)
            String[] accountInfo = accountLine.split(",");

            // capture values from string[]
            String owner = accountInfo[0];
            BigDecimal balance = new BigDecimal(accountInfo[1]);

            // instantiate account
            Account account = new Account(owner, balance);
            accounts.add(account);
        }
        return accounts;
    }
}

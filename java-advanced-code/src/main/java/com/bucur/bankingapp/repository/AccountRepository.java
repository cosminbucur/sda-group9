package com.bucur.bankingapp.repository;

import com.bucur.bankingapp.export.CustomFileWriter;
import com.bucur.bankingapp.model.Account;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountRepository {

    // use file writer to persist accounts
    private CustomFileWriter fileWriter;


    // internal instantiation
//    public AccountRepository() {
//        this.fileWriter = new NioCustomFileWriter();
//    }

    // dependency injection
    // external instantiation
    public AccountRepository(CustomFileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    // in memory db
    private static List<Account> accounts = new ArrayList<>();

    // implement create account
    public void createAccount() {
        // grab user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Specify the owner name: ");
        String owner = scanner.nextLine();

        System.out.println("Initial deposit: ");
        BigDecimal balance = scanner.nextBigDecimal();

        try {
            Account account = new Account(owner, balance);
            accounts.add(account);

            fileWriter.persist(account);
            System.out.println("info: account created " + account);
        } catch (IOException e) {
            System.out.println("error: failed to persist account");
        }


    }
}

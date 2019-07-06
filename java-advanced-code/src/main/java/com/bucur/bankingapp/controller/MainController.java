package com.bucur.bankingapp.controller;

import com.bucur.bankingapp.repository.AccountRepository;

public class MainController {

    private AccountRepository accountRepository;

    public MainController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // get input from user and delegate to a method
    public void dispatch(int option) {
        // 1 -> create account
        while (option != 0) {
            switch (option) {
                case 1:
                    accountRepository.createAccount();
                case 2:
                    // TODO: implement find all
            }
        }
        // 2 -> find all accounts
    }
}

package com.bucur.bankingapp;

import com.bucur.bankingapp.controller.MainController;
import com.bucur.bankingapp.export.CustomFileWriter;
import com.bucur.bankingapp.export.NioCustomFileWriter;
import com.bucur.bankingapp.repository.AccountRepository;
import com.bucur.bankingapp.ui.MenuBuilder;

import java.io.IOException;
import java.util.Scanner;

public class HomeBankApp {

    public static void main(String[] args) throws IOException {
        // create app objects
        Scanner scanner = new Scanner(System.in);
        MenuBuilder menuBuilder = new MenuBuilder();

        CustomFileWriter customFileWriter = new NioCustomFileWriter();
        AccountRepository accountRepository = new AccountRepository(customFileWriter);
        MainController controller = new MainController(accountRepository);

        // run program
        menuBuilder.displayMenu();

        // grab user input
        int option = scanner.nextInt();

        // dispatch input
        controller.dispatch(option);
    }
}

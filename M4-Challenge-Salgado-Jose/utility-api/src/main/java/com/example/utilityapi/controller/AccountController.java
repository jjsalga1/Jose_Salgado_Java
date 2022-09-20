package com.example.utilityapi.controller;

import com.example.utilityapi.models.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;

@RestController
public class AccountController {

    private List<Account> accountList;

    private static int idCounter = 1;

    public AccountController() {
        accountList = new ArrayList<>();

        accountList.add(new Account("Robert Williams", "TexasAM_44", idCounter++));
        accountList.add(new Account("Danny Ainge", "BYU_44", idCounter++));
        accountList.add(new Account("Brian Scalabrine", "USC_44", idCounter++));
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Account createAccount(@RequestBody @Valid Account account) {

        // Handle and check for duplicate username
        for (Account a : accountList) {
            if (a.getUsername().equals(account.getUsername())) {
                throw new IllegalArgumentException("Duplicate Error: Username already exists");
            }
        }

        account.setId(idCounter++);
        accountList.add(account);

        return account;
    }
}

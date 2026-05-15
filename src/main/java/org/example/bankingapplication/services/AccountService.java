package org.example.bankingapplication.services;

import org.example.bankingapplication.Dto.AccountDto;

import java.util.*;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    List<AccountDto> getAllAccounts();
    AccountDto getAccountById(UUID id);
    AccountDto addAmountById(UUID id, double amount);
    AccountDto withdrawAmount(UUID id, double amount);

    void deleteAccount(UUID id);
    // AccountDto deleteAccount(UUID id);

    void transferAmount(UUID fromId, UUID toId, double amount);

    public Object searchAccount(String query);

}

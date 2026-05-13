package org.example.bankingapplication.services.serviceImpl;

import org.example.bankingapplication.Dto.AccountDto;
import org.example.bankingapplication.entity.*;
import org.example.bankingapplication.mapper.AccountMapper;
import org.example.bankingapplication.repository.AccountRepository;
import org.example.bankingapplication.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountById(UUID id) {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not found"));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto addAmountById(UUID id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Not found"));
        account.setBalance(account.getBalance() + amount);
        Account saveAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto withdrawAmount(UUID id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Not found"));
        if(account.getBalance() > amount){
            account.setBalance(account.getBalance() - amount);
        }

        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public void deleteAccount(UUID id) {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Not found"));
        accountRepository.delete(account);

    }
}

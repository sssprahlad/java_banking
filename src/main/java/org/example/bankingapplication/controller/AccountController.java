package org.example.bankingapplication.controller;

import org.example.bankingapplication.Dto.AccountDto;
import org.example.bankingapplication.services.serviceImpl.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountServiceImpl service;

    public AccountController(AccountServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(service.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        return new ResponseEntity<>(service.getAllAccounts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable UUID id){
        return new ResponseEntity<>(service.getAccountById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable UUID id, @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        AccountDto accountDto = service.addAmountById(id, amount);

        return  new ResponseEntity<>(accountDto,HttpStatus.OK);

    }

    @PatchMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawAmount(@PathVariable UUID id, @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        AccountDto accountDto = service.withdrawAmount(id, amount);

        return  new ResponseEntity<>(accountDto,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable UUID id){
        service.deleteAccount(id);

        return ResponseEntity.ok("Account deleted successfully.");

    }

    @GetMapping("/test")
    public String testing(){
        return "Hello world";
    }


}

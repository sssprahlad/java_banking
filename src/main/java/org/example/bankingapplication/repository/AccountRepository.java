package org.example.bankingapplication.repository;

import org.example.bankingapplication.Dto.AccountDto;
import org.example.bankingapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
//  public List<Account> getByAccountHolderName(String accountHolderName);
@Query("SELECT a FROM Account a WHERE LOWER(a.accountHolderName) LIKE LOWER(CONCAT('%', :name, '%'))")
List<Account> findByAccountHolderName(@Param("name") String name);
}

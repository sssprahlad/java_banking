package org.example.bankingapplication.Dto;

import lombok.*;
import java.util.*;

@Getter
@Setter
public class TransferRequestDto {
    private UUID selectedFromAccount;
    private UUID selectedToAccount;
    private double transferAmount;

}

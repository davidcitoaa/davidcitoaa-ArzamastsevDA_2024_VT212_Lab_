package bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class PaymentAccount {
    private String id; // Идентификатор платёжного счета
    private User user; // Пользователь, за которым закреплен этот платежный счет
    private Bank bank; // Банк, в котором открыт этот счет
    private double balance = 0.0; // Начальный баланс по умолчанию 0
}
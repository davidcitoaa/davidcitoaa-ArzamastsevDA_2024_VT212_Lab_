package bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class BankOffice {
    private String id; // Идентификатор банковского офиса
    private String name; // Название офиса
    private String address; // Адрес банковского офиса
    private String status = "работает"; // Статус (работает/не работает)
    private boolean canPlaceAtm; // Можно ли разместить банкомат?
    private int atmCount = 0; // Кол-во банкоматов в офисе
    private boolean canIssueCredit; // Можно ли оформить кредит в офисе?
    private boolean canWithdraw; // Работает ли на выдачу денег?
    private boolean canDeposit; // Можно ли внести деньги?
    private double amountOfMoney = 0; // Кол-во денег в офисе
    private double rentCost; // Стоимость аренды офисного помещения




}
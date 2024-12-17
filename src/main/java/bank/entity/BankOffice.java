package bank.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data // Создает геттеры и сеттеры для всех полей + toString и другие
@NoArgsConstructor // Конструктор без параметров
@AllArgsConstructor // Конструктор со всеми параметрами
public class BankOffice {
    private String id; // Идентификатор банковского офиса
    private String name; // Название офиса
    private String address; // Адрес банковского офиса
    private String status; // Статус (работает/не работает)
    private boolean canPlaceAtm; // Можно ли разместить банкомат?
    private int atmCount; // Количество банкоматов
    private boolean canIssueCredit; // Можно ли оформить кредит в офисе?
    private boolean canWithdraw; // Работает ли на выдачу денег?
    private boolean canDeposit; // Можно ли внести деньги?
    private double amountOfMoney; // Кол-во денег в офисе
    private double rentCost; // Стоимость аренды офисного помещения

    @ToString.Exclude
    private List<BankAtm> atmList = new ArrayList<>(); // Список банкоматов

    public void addAtm(BankAtm atm) {
        this.getAtmList().add(atm); // Добавляем банкомат в офис
        this.setAtmCount(this.getAtmList().size()); // Обновляем количество ATM в офисе
    }



    // Ломбок с аннотацией @Data автоматически создает геттер
    @Getter
    @ToString.Exclude
    private List<Employee> employeeList = new ArrayList<>();


}
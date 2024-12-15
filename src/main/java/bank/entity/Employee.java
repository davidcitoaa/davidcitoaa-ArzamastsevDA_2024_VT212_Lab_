package bank.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Employee {
    private String id; // Идентификатор сотрудника
    private String fullName; // ФИО сотрудника
    private Date birthDate; // Дата рождения
    private String position; // Должность
    private Bank bank; // Банк, в котором работает
    private boolean worksRemotely; // Работает ли в офисе или удаленно
    private BankOffice bankOffice; // Банковский офис, в котором работает (может быть null)
    private boolean canIssueCredits; // Может ли выдавать кредиты
    private double salary; // Размер зарплаты
}
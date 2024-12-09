package bank.entity;

import java.util.Date;

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

    // Конструктор класса
    public Employee(String id, String fullName, Date birthDate,
                    String position, Bank bank, boolean worksRemotely,
                    BankOffice bankOffice, boolean canIssueCredits, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.position = position;
        this.bank = bank;
        this.worksRemotely = worksRemotely;
        this.bankOffice = bankOffice;
        this.canIssueCredits = canIssueCredits;
        this.salary = salary;
    }

    // Геттеры для полей
    public String getId() {
        return id;
    }

    public String getName() {
        return fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPosition() {
        return position;
    }

    public Bank getBank() {
        return bank;
    }

    public boolean isWorksRemotely() {
        return worksRemotely;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public boolean isCanIssueCredits() {
        return canIssueCredits;
    }

    public double getSalary() {
        return salary;
    }
    //Переопределение метода toString()
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", position='" + position + '\'' +
                ", bank=" + (bank != null ? bank.getName() : "не указан") + // Получение имени банка
                ", worksRemotely=" + worksRemotely +
                ", bankOffice=" + (bankOffice != null ? bankOffice.getName() : "не указан") + // Получение имени офиса
                ", canIssueCredits=" + canIssueCredits +
                ", salary=" + salary +
                '}';
    }
}
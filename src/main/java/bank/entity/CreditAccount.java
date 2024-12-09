package bank.entity;

import java.util.Date;

public class CreditAccount {
    private String id; // Идентификатор кредитного счета
    private User user; // Пользователь, за которым закреплен этот кредитный счет
    private Bank bank; // Банк, где взят кредит
    private Date startDate; // Дата начала кредита
    private Date endDate; // Дата окончания кредита
    private int durationMonths; // Кол-во месяцев, на которые взят кредит
    private double loanAmount; // Сумма кредита
    private double monthlyPayment; // Ежемесячный платеж
    private double interestRate; // Процентная ставка
    private Employee employee; // Сотрудник, который выдал кредит
    private String repaymentAccount; // Платежный счет для погашения кредита

    // Конструктор класса
    public CreditAccount(String id, User user, Bank bank, Date startDate,
                         Date endDate, int durationMonths, double loanAmount,
                         double interestRate, Employee employee, String repaymentAccount) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationMonths = durationMonths;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.employee = employee;
        this.repaymentAccount = repaymentAccount;
        this.monthlyPayment = calculateMonthlyPayment(); // Расчет ежемесячного платежа
    }

    // Метод для расчета ежемесячного платежа
    private double calculateMonthlyPayment() {
        if (durationMonths == 0) {
            return 0;
        }
        double monthlyRate = interestRate / 100 / 12; // Перевод процентной ставки в месячную
        return (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -durationMonths));
    }

    // Геттеры для полей
    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Bank getBank() {
        return bank;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getRepaymentAccount() {
        return repaymentAccount;
    }
    //Переопределение метода toString()
    @Override
    public String toString() {
        return "CreditAccount{" +
                "id='" + id + '\'' +
                ", user=" + user.getName() +
                ", bank=" + bank.getName() +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", durationMonths=" + durationMonths +
                ", loanAmount=" + loanAmount +
                ", monthlyPayment=" + monthlyPayment +
                ", interestRate=" + interestRate +
                ", employee=" + employee.getName() +
                ", repaymentAccount='" + repaymentAccount + '\'' +
                '}';
    }
}
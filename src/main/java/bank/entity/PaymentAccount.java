package bank.entity;

public class PaymentAccount {
    private String id; // Идентификатор платёжного счета
    private User user; // Пользователь, за которым закреплен этот платежный счет
    private Bank bank; // Банк, в котором открыт этот счет
    private double balance; // Сумма, которая лежит на счету (по умолчанию 0)

    // Конструктор класса
    public PaymentAccount(String id, User user, Bank bank) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.balance = 0.0; // Начальный баланс по умолчанию 0
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

    public double getBalance() {
        return balance;
    }


    //Переопределение метода toString()
    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id='" + id + '\'' +
                ", user=" + user.getName() + // Предполагается, что у класса User есть метод getName()
                ", bank=" + (bank != null ? bank.getName() : "не указан") + // Предполагается, что у класса Bank есть метод getName()
                ", balance=" + balance +
                '}';
    }
}
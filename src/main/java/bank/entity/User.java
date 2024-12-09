package bank.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;

public class User {
    private String id; // Идентификатор клиента
    private String fullName; // ФИО клиента
    private Date birthDate; // Дата рождения
    private String workplace; // Место работы
    private double monthlyIncome; // Ежемесячный доход
    private List<Bank> banks; // Список банков, которыми пользуется клиент
    private List<CreditAccount> creditAccounts; // Список кредитных счетов
    private List<PaymentAccount> paymentAccounts; // Список платёжных счетов
    private int creditRating; // Кредитный рейтинг

    // Конструктор класса
    public User(String id, String fullName, Date birthDate, String workplace) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.workplace = workplace;
        this.monthlyIncome = generateMonthlyIncome(); // Генерация месячного дохода
        this.banks = new ArrayList<>(); // Инициализация списка банков
        this.creditAccounts = new ArrayList<>(); // Инициализация списка кредитных счетов
        this.paymentAccounts = new ArrayList<>(); // Инициализация списка платёжных счетов
        this.creditRating = calculateCreditRating(); // Рассчет кредитного рейтинга
    }

    // Метод для генерации рандомного месячного дохода (от 0 до 10 000)
    private double generateMonthlyIncome() {
        Random rand = new Random();
        return rand.nextDouble() * 10000; // Генерация случайного числа в диапазоне 0 - 10 000
    }

    // Метод для расчета кредитного рейтинга
    private int calculateCreditRating() {
        if (monthlyIncome < 1000) {
            return 100;
        } else if (monthlyIncome < 2000) {
            return 200;
        } else if (monthlyIncome < 3000) {
            return 300;
        } else if (monthlyIncome < 4000) {
            return 400;
        } else if (monthlyIncome < 5000) {
            return 500;
        } else if (monthlyIncome < 6000) {
            return 600;
        } else if (monthlyIncome < 7000) {
            return 700;
        } else if (monthlyIncome < 8000) {
            return 800;
        } else if (monthlyIncome < 9000) {
            return 900;
        } else {
            return 1000;
        }
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

    public String getWorkplace() {
        return workplace;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public List<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public List<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public int getCreditRating() {
        return creditRating;
    }

    //Получение ежемесячного дохода
    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    //Переопределение метода toString()
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", workplace='" + workplace + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", creditRating=" + creditRating +
                ", banks=" + banks +
                ", creditAccounts=" + creditAccounts.size() +
                ", paymentAccounts=" + paymentAccounts.size() +
                '}';
    }
}
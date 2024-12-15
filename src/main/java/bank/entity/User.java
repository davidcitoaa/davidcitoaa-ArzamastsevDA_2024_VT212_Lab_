package bank.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor // Генерирует конструктор без параметров
@AllArgsConstructor // Генерирует конструктор со всеми параметрами
public class User {
    private String id; // Идентификатор клиента
    private String fullName; // ФИО клиента
    private Date birthDate; // Дата рождения
    private String workplace; // Место работы
    private double monthlyIncome; // Ежемесячный доход
    @ToString.Exclude // Исключение из метода toString()
    private List<Bank> banks = new ArrayList<>(); // Инициализация списка банков

    @ToString.Exclude // Исключение из метода toString()
    private List<CreditAccount> creditAccounts = new ArrayList<>(); // Инициализация списка кредитных счетов

    @ToString.Exclude // Исключение из метода toString()
    private List<PaymentAccount> paymentAccounts = new ArrayList<>(); // Инициализация списка платёжных счетов
    private int creditRating; // Кредитный рейтинг

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
}
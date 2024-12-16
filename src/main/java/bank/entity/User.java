package bank.entity;

import java.time.LocalDate;
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

    // Метод для вычисления кредитного рейтинга
    public void calculateCreditRating() {
        int age = calculateAge(); // Возраст пользователя

        // Расчет кредитного рейтинга на основе зарплаты и возраста
        creditRating = 1000 + (int) ((monthlyIncome / 1000) * 200) + ((age - 18) * 10);
    }

    // Метод для вычисления возраста пользователя
    private int calculateAge() {
        int currentYear = LocalDate.now().getYear(); // Получаем текущий год
        int birthYear = birthDate.getYear() + 1900;  // Преобразование года из Date (т.к. Date.getYear() возвращает год - 1900)
        return currentYear - birthYear;
    }

    // Метод для проверки, подходит ли пользователь для получения кредита
    public boolean isEligibleForCredit(double requiredMonthlyIncome) {
        // Если кредитный рейтинг больше или равен 5000, то пользователь может получить кредит
        calculateCreditRating();
        return creditRating >= requiredMonthlyIncome;
    }
}
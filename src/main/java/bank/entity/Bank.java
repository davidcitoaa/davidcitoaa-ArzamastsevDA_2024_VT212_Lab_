package bank.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.ToString;

@ToString
@Data // Создает геттеры и сеттеры для всех полей + toString, equals, hashCode и другие
@NoArgsConstructor // Генерирует конструктор без параметров
@AllArgsConstructor // Генерирует конструктор со всеми параметрами
public class Bank {
    private String id; // Идентификатор банка
    private String name; // Имя банка
    private int officeCount; // Кол-во офисов
    private int atmCount; // Кол-во банкоматов
    private int employeeCount; // Кол-во сотрудников
    private int clientCount; // Кол-во клиентов
    private int rating; // Рейтинг банка
    private double totalMoney; // Всего денег в банке
    private double interestRate; // Процентная ставка

    private static final Random random = new Random();

    // Храним офисы в списке
    @Getter
    @ToString.Exclude
    private List<BankOffice> offices = new ArrayList<>();


    public Bank(String id, String name) {
        this.id = id;
        this.name = name;
        this.rating = generateRating();
        this.totalMoney = generateTotalMoney();
        this.interestRate = generateInterestRate(rating);
    }

    // Методы для работы с офисами
    public void setOffices(List<BankOffice> offices) {
        this.offices = offices;
        this.officeCount = offices.size(); // Обновляем количество офисов
    }

    // Генерация рейтинга банка от 0 до 100
    private int generateRating() {
        return random.nextInt(101);
    }

    // Генерация суммы денег в банке от 0 до 1,000,000
    private double generateTotalMoney() {
        return random.nextDouble() * 1_000_000;
    }

    // Генерация процентной ставки в зависимости от рейтинга
    private double generateInterestRate(int rating) {
        double baseRate = random.nextDouble() * 20; // Максимальная ставка 20%
        // Уменьшение ставки в зависимости от рейтинга
        return baseRate * (1 - rating / 100.0);
    }

}
package bank.entity;

import java.util.Random;

public class Bank {
    private String id; // Идентификатор банка
    private String name; // Имя банка
    public int officeCount = 0; // Кол-во офисов
    public int atmCount = 0; // Кол-во банкоматов
    public int employeeCount = 0; // Кол-во сотрудников
    public int clientCount = 0; // Кол-во клиентов
    private int rating; // Рейтинг банка
    private double totalMoney; // Всего денег в банке
    private double interestRate; // Процентная ставка

    private static final Random random = new Random();

    public Bank(String id, String name) {
        this.id = id;
        this.name = name;
        this.rating = generateRating();
        this.totalMoney = generateTotalMoney();
        this.interestRate = generateInterestRate(rating);
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


    // Геттеры для полей
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOfficeCount() {
        return officeCount;
    }

    public int getAtmCount() {
        return atmCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public int getClientCount() {
        return clientCount;
    }

    public int getRating() {
        return rating;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public double getInterestRate() {
        return interestRate;
    }
    //Переопределение метода toString()
    @Override
    public String toString() {
        return "Bank{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", officeCount=" + officeCount +
                ", atmCount=" + atmCount +
                ", employeeCount=" + employeeCount +
                ", clientCount=" + clientCount +
                ", rating=" + rating +
                ", totalMoney=" + totalMoney +
                ", interestRate=" + interestRate +
                '}';
    }
}
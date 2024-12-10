package bank;

import bank.entity.*;
import bank.service.*;
import bank.service.impl.*;

import java.util.Date;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Автоматическая инициализация банковского офиса
        BankOffice office = new BankOffice(
                "1",                            // ID
                "Главный офис",                // Название
                "Улица Главная, 1",            // Адрес
                true,                          // Можно ли разместить банкомат
                true,                          // Можно ли оформить кредит
                true,                          // Можно ли выдавать деньги
                true,                          // Можно ли вносить деньги
                1500.00                       // Стоимость аренды
        );
        // Вывод информации о банковском офисе
        System.out.println(office);

        // Автоматическая инициализация банка
        Bank bank = new Bank("1", "Мой Банк");
        // Вывод информации о банке
        System.out.println(bank);


        // Автоматическая инициализация банкомата
        BankAtm atm = new BankAtm(
                "ATM001",                        // ID банкомата
                "Банкомат 1",                   // Имя банкомата
                "Улица Главная, 2",             // Адрес
                bank,                            // Банк
                "Рядом с офисом",               // Расположение
                "Иванов И.И.",                  // Обслуживающий сотрудник
                true,                           // Можно ли выдавать деньги
                true,                           // Можно ли вносить деньги
                50000.00,                      // Кол-во денег в банкомате
                200.00                         // Стоимость обслуживания
        );

        // Вывод информации о банкомате
        System.out.println(atm);

        // Создание объекта пользователя
        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, Calendar.JANUARY, 1); // Установка даты рождения
        Date birthDate = calendar.getTime();

        User user = new User("U001", "Иванов Иван", birthDate, "ООО Ромашка");

        // Создание объектов банков
        Bank bank1 = new Bank("B001", "Мой Банк");
        Bank bank2 = new Bank("B002", "Другой Банк");

        // Добавление банков в список пользователя
        user.getBanks().add(bank1);
        user.getBanks().add(bank2);

        // Создание объекта сотрудника
        Employee employee = new Employee(
                "E001", // ID сотрудника
                "Петров Петр", // ФИО сотрудника
                birthDate, // Дата рождения
                "Менеджер по кредитам", // Должность
                bank, // Банк, в котором работает
                false, // Работает ли удаленно
                office, // Банковский офис
                true, // Может ли выдавать кредиты
                50000 // Размер зарплаты
        );

        // Вывод информации о сотруднике
        System.out.println(employee);

        // Создание объекта кредитного счета
        CreditAccount creditAccount = new CreditAccount(
                "CA001",
                user,
                bank1,
                new Date(), // Дата начала кредита
                new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000), // Дата окончания кредита, через год
                12, // Количество месяцев
                50000, // Сумма кредита
                5.0, // Процентная ставка
                employee,
                "RU1234567890" // Платежный счет для погашения кредита
        );

        // Добавление кредитного счета к пользователю
        user.getCreditAccounts().add(creditAccount);

        // Вывод информации о пользователе
        System.out.println(user);

        //Вывод информации о кредитном счете
        System.out.println(creditAccount);


        // Создание платежного счета
        PaymentAccount paymentAccount = new PaymentAccount("PA001", user, bank);

        // Вывод информации о платёжном счете
        System.out.println(paymentAccount);
    }
}
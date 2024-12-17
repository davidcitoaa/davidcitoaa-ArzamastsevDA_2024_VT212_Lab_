package bank;

import bank.entity.*;
import bank.service.*;
import bank.service.impl.*;
import bank.exception.*;
import bank.util.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Создаем список банков
        List<Bank> banks = new ArrayList<>();

        // Создаем банки и добавляем их в список
        for (int i = 1; i <= 5; i++) {
            Bank bank = new Bank(
                    "B" + i,
                    "Банк " + i
            );
            banks.add(bank);
        }

        // Создаем пользователя
        User user = new User("U001", "Иванов Иван", DateUtils.generateRandomBirthDate(1970, 2000), "ИП Иванов", 60000, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0);

        // Создаем офисы и банкоматы для каждого банка
        for (Bank bank : banks) {
            // Создаем офисы
            List<BankOffice> offices = new ArrayList<>();
            for (int j = 1; j <= 3; j++) { // Пример: 2 офиса
                BankOffice office = new BankOffice(
                        "O" + j,
                        "Офис " + j,
                        "Адрес Офиса " + j,
                        "работает",
                        true, // Может размещать банкоматы
                        0, // Начальное количество банкоматов
                        true, // Может выдавать кредиты
                        true, // Можно снимать деньги
                        true, // Можно вносить деньги
                        1500.00, // Количество денег в офисе
                        0, // Стоимость аренды
                        new ArrayList<>(),
                        new ArrayList<>()
                );
                offices.add(office);

                // Добавление сотрудников в офис
                for (int empNum = 1; empNum <= 5; empNum++) { // Например, 5 сотрудников
//                    // Генерация случайной даты рождения
//                    Random random = new Random();
//                    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//                    int year = 1970 + random.nextInt(currentYear - 1970 + 1); // Случайный год от 1970 до текущего года
//                    int month = 0;//random.nextInt(12); // Случайный месяц от 0 до 11
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.set(year, month, 1);
//                    int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // Максимальное количество дней в месяце
//                    int day = 1 + random.nextInt(maxDay); // Случайный день месяца
//
//                    // Установка даты рождения
//                    calendar.set(year, month, day);

//                    Date birthDate = calendar.getTime();
                    Date birthDate = DateUtils.generateRandomBirthDate(1970, 2000);
                    Employee employee = new Employee(
                            "E" + empNum,
                            "Сотрудник " + empNum,
                            birthDate,
                            "Менеджер", // Должность
                            bank, // Банк, в котором работает сотрудник
                            false, // Работает ли удаленно
                            office, // Привязка сотрудника к офису
                            empNum % 2 == 0, // Пусть только четные сотрудники могут выдавать кредиты
                            40000.00 // Зарплата сотрудника
                    );
                    office.getEmployeeList().add(employee);
                }

                // Создаем банкоматы для этого офиса
                for (int atmNum = 1; atmNum <= 3; atmNum++) { // Пример: 5 банкоматов
                    BankAtm atm = new BankAtm(
                            "ATM" + atmNum + "_" + j,
                            "Банкомат " + atmNum + " в офисе " + j,
                            "Адрес банкомата " + atmNum + " в офисе " + j,
                            "работает",
                            bank,
                            "Расположение банкомата",
                            "Сотрудник " + atmNum,
                            true,
                            true,
                            1_000_000.00,
                            200.00
                    );
                    office.addAtm(atm); // Добавляем банкомат в офис
                }
            }
            bank.setOffices(offices); // Устанавливаем офисы в банке
        }



        // Запрашиваем кредит
        try {
            double requestedAmount = 10000; // Запрашиваемая сумма кредита
            CreditService.requestCredit(user, banks, requestedAmount);
        } catch (CreditRequestException e) {
            System.err.println("Ошибка при получении кредита: " + e.getMessage());
        }

        // Вывод информации о пользователе и его кредитах
        System.out.println("Пользователь: " + user);
        System.out.println("Кредиты пользователя: " + user.getCreditAccounts());
    }
}
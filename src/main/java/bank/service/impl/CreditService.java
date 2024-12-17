package bank.service.impl;

import bank.entity.*;
import bank.exception.*;

import java.util.Collections;
import java.util.List;

public class CreditService {

    /**
     * Метод для запроса кредита клиентом.
     *
     * @param user            Клиент, запрашивающий кредит.
     * @param banks           Список доступных банков.
     * @param requestedAmount Сумма, которую клиент хочет получить в кредит.
     * @throws CreditRequestException Если возникают ошибки при получении кредита.
     */
    public static void requestCredit(User user, List<Bank> banks, double requestedAmount) throws CreditRequestException {
        // Проверка наличия банков
        if (banks.isEmpty()) {
            throw new InvalidBankException("Нет доступных банков для выбора.");
        }

        // Выбор банка с максимальным числом атрибутов
        Bank selectedBank = Collections.max(banks, (b1, b2) -> {
            int atmComparison = Integer.compare(b1.getAtmCount(), b2.getAtmCount());
            if (atmComparison != 0) return atmComparison;
            int officeComparison = Integer.compare(b1.getOfficeCount(), b2.getOfficeCount());
            if (officeComparison != 0) return officeComparison;
            return Integer.compare(b1.getEmployeeCount(), b2.getEmployeeCount());
        });

        // Если клиент еще не является клиентом банка, добавляем его
        if (!user.isClientOfBank(selectedBank)) {
            selectedBank.addClient(user); // Добавляем клиента в банк
            System.out.println("Клиент " + user.getFullName() + " добавлен в список клиентов банка " + selectedBank.getName());
        }


        // Проверка наличия офисов в выбранном банке
        List<BankOffice> bankOffices = selectedBank.getOffices();
        BankOffice selectedOffice = selectOffice(bankOffices);

        // Проверка доступного сотрудника для обработки кредита
        Employee selectedEmployee = selectEmployee(selectedOffice);

        // Проверка кредитного рейтинга клиента
        if (!user.isEligibleForCredit(5000) && selectedBank.getRating() > 50) {
            throw new LowCreditRatingException("Клиенту отказано в кредите из-за низкого кредитного рейтинга.");
        }

        // Проверка наличия счета клиента в выбранном банке
        PaymentAccount paymentAccount = user.getPaymentAccounts().stream()
                .filter(account -> account.getBank().equals(selectedBank))
                .findFirst()
                .orElseGet(() -> createPaymentAccount(user, selectedBank));

        // Поиск банкомата для выдачи кредита
        BankAtm atm = findAtmInOffice(selectedOffice, requestedAmount);

        // Выдача кредита
        CreditAccount creditAccount = new CreditAccount(
                "CA" + System.currentTimeMillis(),
                user,
                selectedBank,
                new java.util.Date(),
                new java.util.Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000), // Один год
                12, // Срок кредита в месяцах
                requestedAmount,
                selectedBank.getInterestRate(), // Процентная ставка
                selectedEmployee,
                paymentAccount.getId() // ID платежного счета для погашения кредита
        );

        user.getCreditAccounts().add(creditAccount);
        System.out.println("Кредит успешно выдан!");
    }

    private static BankOffice selectOffice(List<BankOffice> bankOffices) throws InvalidOfficeException {
        // Выбор офиса
        for (BankOffice office : bankOffices) {
            if ("работает".equals(office.getStatus()) && office.isCanIssueCredit()) {
                return office;
            }
        }
        throw new InvalidOfficeException("Нет доступных офисов для кредитования.");
    }

    private static Employee selectEmployee(BankOffice office) throws CreditRequestException {
        // Выбор сотрудника
        for (Employee employee : office.getEmployeeList()) {
            if (employee.isCanIssueCredits()) {
                return employee;
            }
        }
        throw new CreditRequestException("Нет сотрудников, которые могут выдать кредит.");
    }

    private static PaymentAccount createPaymentAccount(User user, Bank bank) {
        PaymentAccount newAccount = new PaymentAccount("PA" + System.currentTimeMillis(), user, bank, 0);
        user.getPaymentAccounts().add(newAccount);
        return newAccount;
    }

    private static BankAtm findAtmInOffice(BankOffice office, double requestedAmount) throws InsufficientFundsException {
        // Поиск банкомата с достаточным количеством денег
        for (BankAtm atm : office.getAtmList()) {
            if (atm.canWithdraw && atm.getAmountOfMoney() >= requestedAmount) {
                return atm;
            }
        }
        throw new InsufficientFundsException("Нет достаточных средств в банкомате выбранного офиса. Вам нужно обратиться в другой офис.");
    }
}
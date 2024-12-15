package bank.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class CreditAccount {
    private String id; // Идентификатор кредитного счета
    private User user; // Пользователь, за которым закреплен этот кредитный счет
    private Bank bank; // Банк, где взят кредит
    private Date startDate; // Дата начала кредита
    private Date endDate; // Дата окончания кредита
    private int durationMonths; // Кол-во месяцев, на которые взят кредит
    private double loanAmount; // Сумма кредита
    private double interestRate; // Процентная ставка
    private Employee employee; // Сотрудник, который выдал кредит
    private String repaymentAccount; // Платежный счет для погашения кредита

    // Метод для расчета ежемесячного платежа
        public double calculateMonthlyPayment() {
            if (durationMonths == 0) {
                return 0;
            }
            double monthlyRate = interestRate / 100 / 12; // Перевод процентной ставки в месячную
            return (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -durationMonths));
        }

}
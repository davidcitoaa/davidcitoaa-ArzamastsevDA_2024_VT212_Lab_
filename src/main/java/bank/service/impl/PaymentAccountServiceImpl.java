package bank.service.impl;

import bank.entity.PaymentAccount;
import bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl {
    private PaymentAccount paymentAccount;


    //Создание нового платежного счета
    public void create(PaymentAccount newPaymentAccount) {
        this.paymentAccount = newPaymentAccount;
    }

    //Чтение данных платежного счета.
    public PaymentAccount read(String id) {
        if (this.paymentAccount != null && this.paymentAccount.getId() == id) {
            return paymentAccount;
        } else {
            return null;
        }
    }

    //Обновление данных платежного счета.

    public void update(PaymentAccount paymentAccount) {
        if (this.paymentAccount != null && this.paymentAccount.getId() == paymentAccount.getId()) {
            this.paymentAccount = paymentAccount;
        }
    }

    //Удаление платежного счета.
    public void delete(String id) {
        if (this.paymentAccount != null && this.paymentAccount.getId() == id) {
            this.paymentAccount = null;
        }
    }
}
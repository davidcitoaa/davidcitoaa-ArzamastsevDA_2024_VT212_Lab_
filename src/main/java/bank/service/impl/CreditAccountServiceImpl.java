package bank.service.impl;

import bank.entity.CreditAccount;
import bank.service.CreditAccountService;

public class CreditAccountServiceImpl implements CreditAccountService {
    private CreditAccount creditAccount;


    //Создание нового кредитный счета.
    public void create(CreditAccount newUser) {
        this.creditAccount = newUser;
    }


    //Чтение данных кредитный счета.
    public CreditAccount read(String id) {
        if (this.creditAccount != null && this.creditAccount.getId() == id) {
            return creditAccount;
        } else {
            return null;
        }
    }


    //Обновление данных кредитный счета.
    public void update(CreditAccount newUser) {
        if (this.creditAccount != null && this.creditAccount.getId() == newUser.getId()) {
            this.creditAccount = newUser;
        }
    }


    //Удаление кредитный счета.
    public void delete(String id) {
        if (this.creditAccount != null && this.creditAccount.getId() == id) {
            this.creditAccount = null;
        }
    }
}
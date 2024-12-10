package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.service.BankService;

public class BankServiceImpl implements BankService {
    private Bank bank;


    /**
     * Создание нового банка.
     */

    public void create(Bank newUser) {
        this.bank = newUser;
    }

    /**
     * Чтение данных банка.
     *
     * @param id Идентификатор банка
     */

    public Bank read(String id) {
        if (this.bank != null && this.bank.getId() == id) {
            return bank;
        } else {
            return null;
        }
    }

    /**
     * Обновление данных банка.
     */

    public void update(Bank newUser) {
        if (this.bank != null && this.bank.getId() == newUser.getId()) {
            this.bank = newUser;
        }
    }

    /**
     * Удаление банка.
     *
     * @param id Идентификатор банка
     */

    public void delete(String id) {
        if (this.bank != null && this.bank.getId() == id) {
            this.bank = null;
        }
    }

    /**
     * Добавление офиса.
     */
    public void addOffice() {
        this.bank.officeCount++;
    }

    /**
     * Добавление банкомата.
     */
    public void addAtm() {
        this.bank.atmCount++;
    }

    /**
     * Удаление банкомата.
     */
    public void removeAtm() {
        if (bank.atmCount > 0)
            this.bank.atmCount--;
    }

}
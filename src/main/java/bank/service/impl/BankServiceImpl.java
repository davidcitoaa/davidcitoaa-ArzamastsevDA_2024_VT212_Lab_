package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.service.BankService;

public class BankServiceImpl implements BankService {
    private Bank bank;


    /**
     * Создание нового банка.
     */

    public void create(Bank newBank) {
        this.bank = newBank;
    }

    /**
     * Чтение данных банка.
     *
     * @param id Идентификатор банка
     * @return Возвращает объект Bank или null, если банк не найден.
     */

    public Bank read(String id) {
        return (this.bank != null && this.bank.getId().equals(id)) ? bank : null;
    }

    /**
     * Обновление данных банка.
     *
     * @param newBank Новый объект банка для замены.
     */

    public void update(Bank newBank) {
        if (this.bank != null && this.bank.getId().equals(newBank.getId())) {
            this.bank = newBank;
        }
    }

    /**
     * Удаление банка.
     *
     * @param id Идентификатор банка
     */

    public void delete(String id) {
        if (this.bank != null && this.bank.getId().equals(id)) {
            this.bank = null;
        }
    }

    /**
     * Добавление офиса.
     */
    public void addOffice() {
        if (this.bank != null) {
            this.bank.setOfficeCount(this.bank.getOfficeCount() + 1);
        }
    }

    /**
     * Добавление банкомата.
     */
    public void addAtm() {
        if (this.bank != null) {
            this.bank.setAtmCount(this.bank.getAtmCount() + 1);
        }
    }

    /**
     * Удаление банкомата.
     */
    public void removeAtm() {
        if (this.bank != null) {
            this.bank.setAtmCount(this.bank.getAtmCount() - 1);
        }
    }

}
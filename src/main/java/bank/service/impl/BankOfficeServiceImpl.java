package bank.service.impl;

import bank.entity.BankOffice;
import bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    private BankOffice office;


    //Создание оффиса
    public void create(BankOffice newUser) {
        this.office = newUser;
    }


    // Чтение данных офиса
    public BankOffice read(String id) {
        if (this.office != null && this.office.getId() == id) {
            return office;
        } else {
            return null;
        }
    }


    //Обновление данных офиса.
    public void update(BankOffice newUser) {
        if (this.office != null && this.office.getId() == newUser.getId()) {
            this.office = newUser;
        }
    }


    // Удаление офиса
    public void delete(String id) {
        if (this.office != null && this.office.getId() == id) {
            this.office = null;
        }
    }
}

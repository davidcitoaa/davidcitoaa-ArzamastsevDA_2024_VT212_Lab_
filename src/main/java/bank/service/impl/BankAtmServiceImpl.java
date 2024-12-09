package bank.service.impl;

import bank.entity.BankAtm;
import bank.service.BankAtmService;

public class BankAtmServiceImpl implements BankAtmService {
    private BankAtm bankAtm;

    //Создание нового банкомата
    public void create(BankAtm newUser) {
        this.bankAtm = newUser;
    }

    //Чтение данных банкомата
    public BankAtm read(String id) {
        if (this.bankAtm != null && this.bankAtm.getId() == id) {
            return bankAtm;
        } else {
            return null;
        }
    }

    //Обновление данных банкомата
    public void update(BankAtm newUser) {
        if (this.bankAtm != null && this.bankAtm.getId() == newUser.getId()) {
            this.bankAtm = newUser;
        }
    }

    //Удаление банкомата
    public void delete(String id) {
        if (this.bankAtm != null && this.bankAtm.getId() == id) {
            this.bankAtm = null;
        }
    }
}

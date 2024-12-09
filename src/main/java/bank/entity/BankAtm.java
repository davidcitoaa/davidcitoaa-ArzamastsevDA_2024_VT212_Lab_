package bank.entity;

public class BankAtm {
    private String id; // Идентификатор банкомата
    private String name; // Имя банкомата
    private String address; // Адрес, совпадающий с адресом банковского офиса
    private String status; // Статус (работает/не работает/нет денег)
    private Bank bank; // Банк, которому принадлежит банкомат
    private String location; // Расположение банкомата (адрес офисов банка)
    private String servicingEmployee; // Обслуживающий сотрудник
    private boolean canWithdraw; // Может ли банкомат выдавать деньги
    private boolean canDeposit; // Можно ли внести деньги
    private double amountOfMoney; // Кол-во денег в банкомате
    private double maintenanceCost; // Стоимость обслуживания банкомата

    // Конструктор класса
    public BankAtm(String id, String name, String address, Bank bank,
                   String location, String servicingEmployee,
                   boolean canWithdraw, boolean canDeposit,
                   double amountOfMoney, double maintenanceCost) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = "работает"; // По умолчанию банкомат работает
        this.bank = bank;
        this.location = location;
        this.servicingEmployee = servicingEmployee;
        this.canWithdraw = canWithdraw;
        this.canDeposit = canDeposit;
        this.amountOfMoney = amountOfMoney;
        this.maintenanceCost = maintenanceCost;
    }


    // Геттеры для полей (Ниже)
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public Bank getBank() {
        return bank;
    }

    public String getLocation() {
        return location;
    }

    public String getServicingEmployee() {
        return servicingEmployee;
    }

    public boolean canWithdraw() {
        return canWithdraw;
    }

    public boolean canDeposit() {
        return canDeposit;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }
    //Переопределение метода toString()
    @Override
    public String toString() {
        return "BankAtm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", bank=" + bank.getName() +
                ", location='" + location + '\'' +
                ", servicingEmployee='" + servicingEmployee + '\'' +
                ", canWithdraw=" + canWithdraw +
                ", canDeposit=" + canDeposit +
                ", amountOfMoney=" + amountOfMoney +
                ", maintenanceCost=" + maintenanceCost +
                '}';
    }
}

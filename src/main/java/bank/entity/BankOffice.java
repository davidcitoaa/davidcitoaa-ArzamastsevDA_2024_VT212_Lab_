package bank.entity;

public class BankOffice {
    private String id; // Идентификатор банковского офиса
    private String name; // Название офиса
    private String address; // Адрес банковского офиса
    private String status; // Статус (работает/не работает)
    private boolean canPlaceAtm; // Можно ли разместить банкомат?
    private int atmCount; // Кол-во банкоматов в офисе
    private boolean canIssueCredit; // Можно ли оформить кредит в офисе?
    private boolean canWithdraw; // Работает ли на выдачу денег?
    private boolean canDeposit; // Можно ли внести деньги?
    private double amountOfMoney; // Кол-во денег в офисе
    private double rentCost; // Стоимость аренды офисного помещения

    // Конструктор класса
    public BankOffice(String id, String name, String address,
                      boolean canPlaceAtm, boolean canIssueCredit,
                      boolean canWithdraw, boolean canDeposit,
                      double rentCost) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = "работает"; // По умолчанию офис работает
        this.canPlaceAtm = canPlaceAtm;
        this.atmCount = 0; // Начальное значение количества банкоматов
        this.canIssueCredit = canIssueCredit;
        this.canWithdraw = canWithdraw;
        this.canDeposit = canDeposit;
        this.amountOfMoney = 0; // Начальное значение денег в офисе
        this.rentCost = rentCost;
    }


    // Геттеры для полей
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

    public boolean canPlaceAtm() {
        return canPlaceAtm;
    }

    public int getAtmCount() {
        return atmCount;
    }

    public boolean canIssueCredit() {
        return canIssueCredit;
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

    public double getRentCost() {
        return rentCost;
    }



    //Переопределение метода toString()
    @Override
    public String toString() {
        return "BankOffice{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", canPlaceAtm=" + canPlaceAtm +
                ", atmCount=" + atmCount +
                ", canIssueCredit=" + canIssueCredit +
                ", canWithdraw=" + canWithdraw +
                ", canDeposit=" + canDeposit +
                ", amountOfMoney=" + amountOfMoney +
                ", rentCost=" + rentCost +
                '}';
    }
}
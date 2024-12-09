package bank.service.impl;

import bank.entity.Employee;
import bank.service.EmployeeService;


public class EmployeeServiceImpl {
    private Employee employee;


    //Создание нового сотрудника
    public void create(Employee newEmployee) {
        this.employee = newEmployee;
    }


    //Чтение данных сотрудника
    public Employee read(String id) {
        if (this.employee != null && this.employee.getId() == id) {
            return employee;
        } else {
            return null;
        }
    }


    //Обновление данных сотрудника
    public void update(Employee employee) {
        if (this.employee != null && this.employee.getId() == employee.getId()) {
            this.employee = employee;
        }
    }


    //Удаление сотрудника
    public void delete(String id) {
        if (this.employee != null && this.employee.getId() == id) {
            this.employee = null;
        }
    }
}
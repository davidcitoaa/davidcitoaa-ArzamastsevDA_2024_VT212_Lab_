# Online Bank

### Описание проекта
Проект создан в рамках прохождения курса по предмету "Спецификация, архитектура и проектирование программных систем"

# Bank

### Описание:
Объект банк, содержит следующие поля:

- **Id банка**
- **Имя банка**
- **Количество офисов** (заполняется и считается автоматически при добавлении нового офиса, по умолчанию 0)
- **Количество банкоматов** (заполняется и считается автоматически при добавлении нового банкомата, по умолчанию 0)
- **Количество сотрудников** (заполняется и считается автоматически при добавлении нового сотрудника, по умолчанию 0)
- **Количество клиентов** (заполняется и считается автоматически при добавлении нового клиента в банк, по умолчанию 0)
- **Рейтинг банка** (генерируется рандомно, от 0 до 100, где 100 — наивысший балл, чем выше рейтинг банка, тем меньше должна быть процентная ставка)
- **Всего денег в банке** (генерируется рандомно, но не более 1 000 000)
- **Процентная ставка** (генерируется рандомно, но не более 20%, однако нужно учитывать рейтинг банка — чем он выше, тем ставка должна быть меньше)

# BankAtm

### Описание:
Объект банкомат, содержит следующие поля:

- **Id банкомата**
- **Имя банкомата**
- **Адрес** (сопадает с адресом банковского офиса)
- **Статус** (работает/не работает/нет денег)
- **Банк**, которому принадлежит банкомат
- **Расположение банкомата** (банкомат может быть расположен только в банковском офисе)
- **Обслуживающий сотрудник**
- **Работает ли на выдачу денег?** (да/нет)
- **Можно ли внести деньги?** (да/нет)
- **Количество денег в банкомате** (напрямую зависит от поля "Всего денег в банке")
- **Стоимость обслуживания банкомата**

# BankOffice

### Описание:
Объект офис банка, содержит следующие поля:

- **Id банковского офиса**
- **Название офиса**
- **Адрес банковского офиса**
- **Статус** (работает/не работает)
- **Можно ли разместить банкомат?** (да/нет)
- **Количество банкоматов в данном офисе** (напрямую зависит от общего числа банкоматов у банка)
- **Можно ли оформить кредит в данном офисе?** (да/нет)
- **Работает ли на выдачу денег?** (да/нет)
- **Можно ли внести деньги?** (да/нет)
- **Количество денег в банковском офисе** (напрямую зависит от поля "Всего денег в банке")
- **Стоимость аренды банковского офиса**

# CreditAccount

### Описание:
Объект кредитный счет, содержит следующие поля:

- **Id кредитного счета**
- **Пользователь**, за которым закреплен этот кредитный счет
- **Название банка**, где взят кредит
- **Дата начала кредита**
- **Дата окончания кредита**
- **Количество месяцев**, на которые взят кредит
- **Сумма кредита**
- **Ежемесячный платеж**
- **Процентная ставка** (должна быть равной процентной ставке банка, в котором взят кредит, или ниже)
- **Сотрудник**, который выдал кредит
- **Платежный счет в банке**, с которого будет осуществляться погашение данного кредита

# Employee

### Описание:
Объект сотрудник, содержит следующие поля:

- **Id сотрудника**
- **ФИО**
- **Дата рождения**
- **Должность**
- **В каком банке работает**
- **Работает ли в банковском офисе или удаленно?** (да/нет)
- **Банковский офис**, в котором работает
- **Может ли выдавать кредиты?** (да/нет)
- **Размер зарплаты**

# PaymentAccount

### Описание:
Объект платежный счет, содержит следующие поля:

- **Id платежного счета**
- **Пользователь**, за которым закреплен этот платежный счет
- **Название банка**, в котором открыт этот счет
- **Сумма**, которая лежит в данный момент на счету (по умолчанию 0)

# User

### Описание:
Объект клиент банка, содержит следующие поля:

- **Id клиента**
- **ФИО**
- **Дата рождения**
- **Место работы**
- **Ежемесячный доход** (генерируется рандомно, но не более 10 000)
- **Банки**, которыми он пользуется
- **Кредитные счета** (по умолчанию пусто)
- **Платежные счета** (по умолчанию пусто)
- **Кредитный рейтинг для банка** (генерируется рандомно исходя из ежемесячного дохода: от меньше 1 000 – 100, от 1 000 до 2 000 – 200 и т.д. вплоть до 10 000)

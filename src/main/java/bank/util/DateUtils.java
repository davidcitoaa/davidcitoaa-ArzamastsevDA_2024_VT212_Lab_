package bank.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtils {

    /**
     * Генерация случайной даты рождения в заданном диапазоне.
     *
     * @param startYear Год начала диапазона.
     * @param endYear   Год конца диапазона.
     * @return Случайная дата рождения.
     */
    public static Date generateRandomBirthDate(int startYear, int endYear) {
        Random random = new Random();

        // Генерация случайного года
        int year = startYear + random.nextInt(endYear - startYear + 1);

        // Генерация случайного месяца (от 0 до 11)
        int month = random.nextInt(12);

        // Создаем календарь для расчета количества дней в месяце
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);

        // Определяем количество дней в месяце
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Генерация случайного дня месяца (от 1 до maxDay)
        int day = 1 + random.nextInt(maxDay);

        // Устанавливаем дату в календарь
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}

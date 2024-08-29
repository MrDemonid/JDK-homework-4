/*
Создать справочник сотрудников
Необходимо:
    Создать класс справочник сотрудников, который содержит внутри
    коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
        Табельный номер
        Номер телефона
        Имя
        Стаж
    - Добавить метод, который ищет сотрудника по стажу (может быть список)
    - Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
    - Добавить метод, который ищет сотрудника по табельному номеру
    - Добавить метод добавления нового сотрудника в справочник
 */

import java.time.LocalDate;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Directory dir = new Directory();

        /*
            Проверяем заданные методы
         */

        fillDictionary(dir);        // 4. метод добавления нового сотрудника в справочник

        check1(dir, 18, 100);       // 1. метод, который ищет сотрудника по стажу (может быть список)
        check2(dir, "Сергей");      // 2. метод, который возвращает номер телефона сотрудника по имени
        check3(dir, 89);            // 3. метод, который ищет сотрудника по табельному номеру

    }

    private static void check1(Directory dir, int min, int max)
    {
        System.out.printf("\nСотрудники со стажем от %d до %d лет:\n", min, max);
        dir.getPersonByExperience(min, max).forEach(e -> System.out.println("    " + e));

    }

    private static void check2(Directory dir, String name)
    {
        System.out.println("\nТелефоны сотрудника(ов) " + name + ":");
        dir.getPhones(name).forEach(e -> System.out.println("    " + e));
    }

    private static void check3(Directory dir, int tabNo)
    {
        Person p = dir.getPersonByTabNo(tabNo);
        System.out.println("\nСотрудник с табельным номером " + tabNo + ":");
        if (p != null)
            System.out.println("    " + p);
        else
            System.out.println("    отсутствует");
    }


    private static void fillDictionary(Directory dir)
    {
        dir.add(new Person(89, "Андрей", LocalDate.of(2005, 8, 27), new Phone(new HashMap<>() {{
            put("+7-953-445-28-05",PhoneType.MOBILE);
            put("36-96-97",PhoneType.WORK);
            put("65-02", PhoneType.WORK); }})));

        dir.add(new Person(298, "Сергей", LocalDate.of(2016, 11, 2), new Phone(new HashMap<>() {{
            put("223-322-232-233", PhoneType.HOME);
            put("74-80-09", PhoneType.WORK); }})));

        dir.add(new Person(123, "Анна", LocalDate.of(2008, 2, 12), new Phone(new HashMap<>() {{
            put("65-09", PhoneType.WORK); }})));

        dir.add(new Person(8, "Зоя", LocalDate.of(1923, 9, 13), new Phone()));

        dir.add(new Person(1, "Нестор", LocalDate.of(1056, 1, 1), new Phone()));

        dir.add(new Person(28, "Сергей", LocalDate.of(2022, 2, 18), new Phone(new HashMap<>() {{
            put("+7-902-204-80-09", PhoneType.MOBILE); }})));

        System.out.println(dir);
    }
}

import java.util.*;

public class Directory {

    private HashMap<Integer, Person> persons;


    public Directory() {
        persons = new HashMap<>();
    }

    /**
     * Добавление нового сотрудника в справочник
     */
    public void add(Person person)
    {
        persons.put(person.getTabNo(), person);
    }

    /**
     * Поиск сотрудников по стажу в годах
     * @param min Минимальный стаж в годах
     * @param max Максимальный стаж в годах
     */
    public List<Person> getPersonByExperience(int min, int max)
    {
        List<Person> res = new ArrayList<>();

        for (Person person : persons.values())
        {
            int years = person.getWorkExperience() / 12;
            if (years >= min && years <= max)
                res.add(person);
        }
        return res;
    }

    /**
     * Возвращает список телефонов для сотрудников с заданным именем
     * @param name Имя сотрудника
     */
    public List<Phone> getPhones(String name)
    {
        List<Phone> res = new ArrayList<>();

        for (Person person : persons.values()) {
            if (person.isEqualName(name))
                res.add(person.getPhones());
        }
        return res;
    }

    /**
     * Возвращает сотрудника по его табельному номеру
     * @param tabNo Уникальный табельный номер
     */
    public Person getPersonByTabNo(int tabNo)
    {
        return persons.get(tabNo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Список сотрудников:\n");

        for (Person p : persons.values())
        {
            sb.append(p.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}

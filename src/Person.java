import java.time.LocalDate;
import java.time.Period;

public class Person {

    private int tabNo;
    private String name;
    private LocalDate date;     // дата устройства на работу (от нее и будет отсчитывать стаж)
    private Phone phones;

    public Person(int tabNo, String name, LocalDate date, Phone phones) {
        this.tabNo = tabNo;
        this.name = name;
        this.date = date;
        this.phones = phones;
    }

    /**
     * Сравнивает имя текущего пользователя с заданным
     * Создана исключительно ради того, чтобы в дальнейшем
     * расширить имя до фамилии и отчества и производить поиск по неполным
     * данным (например без отчества, или без имени по фамилии).
     * Пока же просто имя.
     */
    public boolean isEqualName(String name)
    {
        return this.name.equalsIgnoreCase(name);
    }

    /**
     * Возвращает стаж работника в месяцах
     */
    public int getWorkExperience()
    {
        Period period = Period.between(date, LocalDate.now());
        return (period.getYears() * 12) + period.getMonths();
    }

    public String getInfoExperience()
    {
        Period period = Period.between(date, LocalDate.now());
        return String.format("%d лет, %d месяцев", period.getYears(), period.getMonths());
    }

    /**
     * Табельный номер сотрудника
     */
    public int getTabNo() {
        return tabNo;
    }

    /**
     * Имя сотрудника
     */
    public String getName() {
        return name;
    }

    /**
     * Телефоны сотрудника
     */
    public Phone getPhones() {
        return phones;
    }

    /**
     * Добавление телефона сотруднику
     * @param number Номер телефона в свободном формате
     * @param type   Тип номера
     */
    public void addPhone(String number, PhoneType type)
    {
        phones.add(number, type);
    }

    /* ================================================================
     *
     * Методы для правильной работы с этим типом данных в Map и Set
     *
     * ================================================================ */

    /*
        Табельные номера уникальны и имеют хорошее рассредоточение,
        почти всегда без пропусков,
        поэтому просто используем их в качестве хеша.
     */
    @Override
    public int hashCode() {
        return tabNo;
    }

    /*
        Соответственно и сотрудников сравниваем по их табельному номеру
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        return tabNo == ((Person) obj).getTabNo();
    }

    @Override
    public String toString() {
        return String.format("[%4d] %-16s, {Стаж: %s}, {%s}", tabNo, name, getInfoExperience(), phones);
    }
}

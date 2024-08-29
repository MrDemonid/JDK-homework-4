import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
    Телефоны бывают разные и могут храниться в разных форматах.
    К тому же у человека их может быть много.
    Поэтому, они оформлены в отдельный класс, упрощающий
    работу с ними, плюс можно привязать и тип номера (домашний, рабочий и тд.).
 */
public class Phone {

    private HashMap<String, PhoneType> phones;


    public Phone(HashMap<String, PhoneType> phones) {
        this.phones = phones;
    }

    public Phone() {
        this(new HashMap<>());
    }

    /**
     * Добавление телефона в список
     * @param number Номер телефона в свободном формате
     * @param type   Тип номера
     */
    public void add(String number, PhoneType type)
    {
        phones.put(number, type);
    }

    /**
     * Возвращает список номеров, без типа
     */
    public Collection<String> getPhones()
    {
        return phones.keySet();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, PhoneType> p : phones.entrySet()) {
            if (!sb.isEmpty())
                sb.append(", ");
            sb.append(p.getKey());
            sb.append(" (");
            sb.append(p.getValue().getDescriptor());
            sb.append(")");
        }
        sb.append("]");
        return "Телефоны: [" + sb;
    }
}

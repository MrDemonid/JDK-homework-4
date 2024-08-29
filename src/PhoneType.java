public enum PhoneType {
    WORK("Рабочий"), HOME("Домашний"), MOBILE("Мобильный");

    private final String descriptor;

    PhoneType(String desc) {
        this.descriptor = desc;
    }

    public String getDescriptor() {
        return descriptor;
    }
}

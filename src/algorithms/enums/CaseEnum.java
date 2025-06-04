package algorithms.enums;

public enum CaseEnum {
    WORST("w", "pior"), BEST("b","melhor"), AVERAGE("m","médio");

    private final String cod;
    private final String desc;

    CaseEnum(String cod,String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public String getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return  desc;
    }
}

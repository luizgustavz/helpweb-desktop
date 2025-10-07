package br.com.luizz4j.helpweb_desktop.domain.enums;

public enum PriorityEnums {

    LOW("0"),
    MEDIA("1"),
    HIGH("2");

    private final String code;

    PriorityEnums(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

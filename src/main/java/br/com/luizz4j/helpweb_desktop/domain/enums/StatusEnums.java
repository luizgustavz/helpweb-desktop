package br.com.luizz4j.helpweb_desktop.domain.enums;

public enum StatusEnums {

    OPEN("0"),
    PROGRESS("1"),
    CLOSED("2");

    private final String code;

    StatusEnums(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

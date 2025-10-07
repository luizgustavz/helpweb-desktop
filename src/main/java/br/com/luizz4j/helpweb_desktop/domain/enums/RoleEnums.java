package br.com.luizz4j.helpweb_desktop.domain.enums;

public enum RoleEnums {

    ADMIN("0", "role_administrator"),
    TECHNICAL("1" ,"role_technical"),
    COLABORATOR("2", "role_colaborator");

    private String code;
    private String position;

    RoleEnums(String code, String position) {
        this.code = code;
        this.position = position;
    }

    public String getCode() {
        return code;
    }

    public String getPosition() {
        return position;
    }
}

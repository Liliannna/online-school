package net.online.school.colors;

public enum ColorErrorCode {
    WRONG_COLOR_STRING("Ошибка выбора цвета"),
    NULL_COLOR("Цвет не выбран");

    private String errorString;

    ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}

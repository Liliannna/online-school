package net.online.school.colors;

public class ColorException extends Exception {

    private ColorErrorCode errorCode;

    public ColorException(ColorErrorCode errorCode){
        this.errorCode = errorCode;
    }

    public ColorErrorCode getErrorCode() {
        return errorCode;
    }
}

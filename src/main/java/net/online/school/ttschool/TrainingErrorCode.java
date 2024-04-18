package net.online.school.ttschool;

public enum TrainingErrorCode {

    TRAINEE_WRONG_FIRSTNAME("wrong firstname"),
    TRAINEE_WRONG_LASTNAME("wrong lastname"),
    TRAINEE_WRONG_RATING("wrong rating"),
    GROUP_WRONG_NAME("group wrong name"),
    TRAINEE_NOT_FOUND("trainee not found"),
    GROUP_WRONG_ROOM("group wrong room"),
    SCHOOL_WRONG_NAME("school wrong name"),
    DUPLICATE_GROUP_NAME("duplicate group name"),
    GROUP_NOT_FOUND("group not found"),
    DUPLICATE_TRAINEE("duplicate trainee"),
    EMPTY_TRAINEE_QUEUE("empty trainee queue");

    private String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}

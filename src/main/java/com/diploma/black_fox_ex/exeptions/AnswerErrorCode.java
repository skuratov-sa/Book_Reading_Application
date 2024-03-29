package com.diploma.black_fox_ex.exeptions;

public enum AnswerErrorCode {
    REGISTRATION_WRONG_USERNAME("Username is too short"),
    REGISTRATION_WRONG_AGE_SYNTAX("Syntax error when entering age"),
    REGISTRATION_WRONG_AGE_RANGE("Invalid age range"),
    REGISTRATION_WRONG_VALIDATE_EMAIL("Invalid email"),
    REGISTRATION_WRONG_VALIDATE_EMAIL_ALREADY_EXIST("This Email already exist"),
    REGISTRATION_WRONG_VALIDATE_PASSWORD("Password error"),
    REGISTRATION_WRONG_VALIDATE_IMG("Such a picture does not exist"),
    REGISTRATION_WRONG_VALIDATE_INFO("Have written too little about yourself"),
    REGISTRATION_WRONG_VALIDATE_SEX("Incorrect gender information"),
    REGISTRATION_USERNAME_ALREADY_EXIST("This username already exist"),

    UPDATE_WRONG_USERNAME("Username is too short"),
    UPDATE_WRONG_AGE("Incorrect age"),
    UPDATE_WRONG_VALIDATE_EMAIL("Invalid email"),
    UPDATE_NOT_ROOT_UPDATE("The user does not have permission to update"),
    UPDATE_WRONG_VALIDATE_EMAIL_ALREADY_EXIST("This Email already exist"),
    UPDATE_WRONG_VALIDATE_PASSWORD("Password error"),
    UPDATE_WRONG_VALIDATE_IMG("Such a picture does not exist"),
    UPDATE_WRONG_VALIDATE_INFO("Have written too little about yourself"),
    UPDATE_WRONG_VALIDATE_SEX("Specify your age"),
    UPDATE_USERNAME_ALREADY_EXIST("This username already exist"),
    UPDATE_WRONG_TELEGRAM_ADDRESS("Error entering username for telegram"),
    UPDATE_WRONG_AGE_SYNTAX("Syntax error when entering age"),
    UPDATE_WRONG_AGE_RANGE("Invalid age range"),

    USER_NOT_REGISTERED("User is not registered"),

    FILE_CREATE_ERROR("Failed to download file"),

    BOOK_ID_NOT_EXIST("There is no book with such an id!"),
    BOOK_SHORT_TEXT("Too short book text!"),
    BOOK_IMG_ERROR("Failed to upload picture!"),
    BOOK_TAG_ERROR("Error you did not specify a genre!"),
    BOOK_TITLE_ERROR("The title of the book is too short!"),
    BOOK_TITLE_ALREADY_EXIST("This title already exists"),
    BOOK_USER_NOT_FOUND("User does not exist!"),
    BOOK_NOT_FOUND("Book does not exist!"),
    BOOK_PAGE_ERROR("There is no such page"),
    PAGE_IS_EMPTY("Blank page"),

    COMMENT_BIG_TEXT_ERROR("Your comment is too small"),
    COMMENT_COLOR_ERROR("Error color!"),

    FAVORITE_USER_ERROR("User does not exist"),
    FAVORITE_BOOK_ID_ERROR("Book id error"),
    ERROR_ANSWER_BY_USER("Sorry, you have no support answers"),

    REQUEST_IS_NULL("Error! Server request is null"),
    EXCEPTION_ERROR("Big error");


    private String msg;

    AnswerErrorCode(String msg) {
        setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        if (msg.length() != 0) {
            this.msg = msg;
        }
    }
}

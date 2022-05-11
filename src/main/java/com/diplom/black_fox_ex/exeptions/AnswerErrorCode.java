package com.diplom.black_fox_ex.exeptions;

public enum AnswerErrorCode {
    REGISTRATION_WRONG_USERNAME("Username is too short"),
    REGISTRATION_WRONG_AGE("Incorrect age"),
    REGISTRATION_WRONG_VOLIDATE_EMAIL("Invalid email"),
    REGISTRATION_WRONG_VOLIDATE_EMAIL_ALREADY_EXIST("This Email already exist"),
    REGISTRATION_WRONG_VOLIDATE_PASSWORD("Password error"),
    REGISTRATION_WRONG_VOLIDATE_IMG("Such a picture does not exist"),
    REGISTRATION_WRONG_VOLIDATE_INFO("Have written too little about yourself"),
    REGISTRATION_WRONG_VOLIDATE_SEX("Specify your age"),
    REGISTRATION_USERNAME_ALREADY_EXIST("This username already exist"),
    REGISTRATION_TELEGRAM_BOT("Error entering username for telegram"),

    USER_NOT_REGISTERED("User is not registered"),
    USER_NOT_ROLE("This user does not have a specified role!"),


    FILE_CREATE_ERROR("Failed to download file"),
    ID_ERROR("Id failed, user is not id in!"),
    TOKEN_ERROR("Token failed, user is not token in!"),

    HISTORY_ID_NOT_EXIST("There is no history with such an id!"),
    HISTORY_SHORT_TEXT("Too short story text!"),
    HISTORY_IMG_ERROR("Failed to upload picture!"),
    HISTORY_TAG_ERROR("Error you did not specify a tag!"),
    HISTORY_TITLE_ERROR("The title of the story is too short!"),
    HISTORY_USER_NOT_FOUND("User does not exist!"),
    HISTORY_NOT_FOUND("History does not exist!"),


    COMMENT_BIGTEXT_ERROR("Your comment is too small"),
    COMMENT_COLOR_ERROR("Error color!"),


    FAVORITE_USER_ERROR("User does not exist"),
    FAVORITE_HISTORY_ID_ERROR("History id error"),
    ERROR_ANSWER_BY_USER("Sorry, you have no support answers");


    private String msg;
    AnswerErrorCode(String msg) {
        setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        if(msg.length() != 0) {
            this.msg = msg;
        }
    }
}
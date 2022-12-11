package lotto.model;

public enum ExceptionMessage {
    ERROR_NOT_NUMBER("숫자를 입력해주세요"), ERROR_WRONG_NUMBER("1000의 배수를 입력해 주세요");
    static final String HEADER = "[ERROR] ";
    String message;
    ExceptionMessage(String body){
        this.message = HEADER + body;
    }
    public String getMessage(){
        return message;
    }

}

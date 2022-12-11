package lotto.model;

public enum ExceptionMessage {
    ERROR_NOT_NUMBER("숫자를 입력해주세요"), ERROR_WRONG_NUMBER("1000의 배수를 입력해 주세요")
    ,ERROR_NOT_ANSWER("숫자와 , 를 이용하여 입력해주세요"), ERROR_WRONG_LENGTH("숫자 6개를 입력해주세요")
    ,ERROR_OVERLAP("중복된 숫자가 있습니다"),ERROR_SCALE("1부터 45 사이의 숫자를 입력해주세요");

    static final String HEADER = "[ERROR] ";
    String message;

    ExceptionMessage(String body){
        this.message = HEADER + body;
    }

    public String getMessage(){
        return message;
    }

}

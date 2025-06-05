package org.example;

public class LengthException extends RuntimeException{
    //預設
    public LengthException() {
        super("密碼要為8-12字元");
    }
    //自訂
    public LengthException(String message) {
        super(message);
    }
}

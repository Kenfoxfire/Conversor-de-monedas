package exception;

public class ErrorDuringPairConversion  extends RuntimeException {
    private final String message;

    public ErrorDuringPairConversion(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

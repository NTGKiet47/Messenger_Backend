package giakiet.messagewebapp.backend.exception;

import giakiet.messagewebapp.backend.enums.ExceptionEnums;
import lombok.*;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@Builder
public class CustomException extends RuntimeException{

    private String message;
    private HttpStatusCode httpStatusCode;
    private String[] args;

    public CustomException(ExceptionEnums exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
        this.httpStatusCode = exceptionEnum.getHttpStatusCode();
    }

    public CustomException(ExceptionEnums exceptionEnum, String... args) {
        super(formatMessage(exceptionEnum.getMessage(), args));
        this.message = exceptionEnum.getMessage();
        this.httpStatusCode = exceptionEnum.getHttpStatusCode();
        this.args = args;
    }

    private static String formatMessage(String pattern, String... args) {
        if (args == null || args.length == 0) {
            return pattern;
        }

        for (int i = 0; i < args.length; i++) {
            pattern = pattern.replace("{" + i + "}", args[i]);
        }
        return pattern;
    }

}

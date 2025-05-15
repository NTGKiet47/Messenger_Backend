package giakiet.messagewebapp.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum ExceptionEnums {
    INFORMATION_EXISTED("Information existed: {}", HttpStatus.CONFLICT),
    NOT_FOUND("{} not found", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND("User not found", HttpStatus.BAD_REQUEST),
    ;

    private final String message;
    private final HttpStatusCode httpStatusCode;
}

package giakiet.messagewebapp.backend.exception;

import giakiet.messagewebapp.backend.dto.base.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExpHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionDto> handleCustomException(CustomException ex) {
        return ResponseEntity.status(ex.getHttpStatusCode()).body(ExceptionDto.builder()
                .message(ex.getMessage())
                .httpStatusCode(ex.getHttpStatusCode())
                .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ExceptionDto.builder()
                .message(ex.getMessage())
                .httpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .build());
    }

}

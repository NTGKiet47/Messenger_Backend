package giakiet.messagewebapp.backend.dto.base;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionDto {

    String message;
    HttpStatusCode httpStatusCode;

}

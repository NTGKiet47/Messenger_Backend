package giakiet.messagewebapp.backend.dto.base;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthResDto extends TrackingCreateDto {
    String token;
    String refreshToken;
    LocalDate expiresAt;

}

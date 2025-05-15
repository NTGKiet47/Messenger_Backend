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
public class TrackingUpdateDto extends TrackingCreateDto {
    String updatedBy;
    LocalDate updatedAt;
}

package giakiet.messagewebapp.backend.entity.base;

import jakarta.persistence.EntityListeners;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class TrackingCreateObject {
    String createdId;
    LocalDate createdAt;
}

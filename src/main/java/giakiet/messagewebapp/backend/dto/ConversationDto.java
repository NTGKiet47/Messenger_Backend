package giakiet.messagewebapp.backend.dto;

import giakiet.messagewebapp.backend.dto.base.TrackingDeleteDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConversationDto extends TrackingDeleteDto {
    Long id;
    String name;
    List<String> userIds;
}

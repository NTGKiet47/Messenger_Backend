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
public class MessageDto extends TrackingDeleteDto {
    String content;
    String senderId;
    List<String> receiverIds;
}

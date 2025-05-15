package giakiet.messagewebapp.backend.dto.base;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataResDto<T> {
    List<T> data;
    int totalDataInPage;
    int currentPage;
    int totalData;
    int totalPage;
}

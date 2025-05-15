package giakiet.messagewebapp.backend.entity;

import giakiet.messagewebapp.backend.entity.base.TrackingDeleteObject;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Conversation extends TrackingDeleteObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    User owner;

    @ManyToMany(mappedBy = "joinedConversations")
    List<User> members;

    @OneToMany(mappedBy = "conversation")
    List<Message> messages = new ArrayList<>();
}

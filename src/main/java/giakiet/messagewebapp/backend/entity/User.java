package giakiet.messagewebapp.backend.entity;

import giakiet.messagewebapp.backend.entity.base.TrackingDeleteObject;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends TrackingDeleteObject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String username;
    String password;
    String email;
    LocalDate birthday;
    String firstName;
    String lastName;
    boolean isActive;
    LocalDate lastActive;
    boolean isEnable;

    @OneToMany(mappedBy = "owner")
    List<Conversation> myConversations = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_conversation",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "conversation_id")
    )
    List<Conversation> joinedConversations = new ArrayList<>();

    @OneToMany(mappedBy = "sender")
    List<Message> messages = new ArrayList<>();
}

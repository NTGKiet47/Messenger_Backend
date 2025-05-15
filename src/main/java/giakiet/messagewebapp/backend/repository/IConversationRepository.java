package giakiet.messagewebapp.backend.repository;

import giakiet.messagewebapp.backend.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConversationRepository extends JpaRepository<Conversation, Long> {



}

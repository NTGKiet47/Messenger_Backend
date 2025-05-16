package giakiet.messagewebapp.backend.configuration;

import giakiet.messagewebapp.backend.constant.ApiConstant;
import giakiet.messagewebapp.backend.constant.UserConsant;
import giakiet.messagewebapp.backend.entity.Message;
import giakiet.messagewebapp.backend.entity.User;
import giakiet.messagewebapp.backend.enums.ExceptionEnums;
import giakiet.messagewebapp.backend.enums.MessageTypeEnums;
import giakiet.messagewebapp.backend.exception.CustomException;
import giakiet.messagewebapp.backend.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Objects;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class WebSocketEvenListener {

    private final SimpMessageSendingOperations messagingTemplate;

    private final IUserRepository userRepository;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) Objects.requireNonNull(
                headerAccessor.getSessionAttributes()).get(UserConsant.USER_NAME);
        if (username != null) {
            log.info("User disconnected: {}", username);
            User user = this.getUserByUsername(username);
            var message = Message.builder()
                    .messageType(MessageTypeEnums.LEAVE.name())
                    .sender(user)
                    .build();
            messagingTemplate.convertAndSend(ApiConstant.API_TOPIC_PUBLIC, message);
        }
    }

    private User getUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    log.error("WebSocketEvenListener | getUserByUsername | ERROR | {}", "User not found" + username);
                    return new CustomException(ExceptionEnums.USER_NOT_FOUND, username);
                });
    }

}

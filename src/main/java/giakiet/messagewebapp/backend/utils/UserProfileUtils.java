package giakiet.messagewebapp.backend.utils;

import giakiet.messagewebapp.backend.entity.User;
import giakiet.messagewebapp.backend.repository.IConversationRepository;
import giakiet.messagewebapp.backend.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileUtils {
    // todo

    private final IUserRepository userRepository;

    private final IConversationRepository conversationRepository;

    public static String getUserId(){
        return "userId";
    }

    public static User getCurrentUser(){
        return new User();
    }

}

package giakiet.messagewebapp.backend.service.impl;

import giakiet.messagewebapp.backend.dto.ConversationDto;
import giakiet.messagewebapp.backend.entity.Conversation;
import giakiet.messagewebapp.backend.entity.User;
import giakiet.messagewebapp.backend.enums.ExceptionEnums;
import giakiet.messagewebapp.backend.exception.CustomException;
import giakiet.messagewebapp.backend.repository.IConversationRepository;
import giakiet.messagewebapp.backend.repository.IUserRepository;
import giakiet.messagewebapp.backend.service.IConversationService;
import giakiet.messagewebapp.backend.utils.UserProfileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConversationServiceImpl implements IConversationService {

    private final IConversationRepository conversationRepository;

    private final IUserRepository userRepository;

    @Override
    public ConversationDto create(ConversationDto conversationDto) {
        try {
            User user = UserProfileUtils.getCurrentUser();
            List<User> participants = conversationDto.getUserIds().stream().map(
                    id -> userRepository.findById(id).orElseThrow(
                            () -> new CustomException(ExceptionEnums.USER_NOT_FOUND))
            ).toList();
            Conversation createdConversation = conversationRepository.save(Conversation.builder()
                    .name(conversationDto.getName())
                    .owner(user)
                    .members(participants)
                    .build());
            return ConversationDto.builder()
                    .id(createdConversation.getId())
                    .name(createdConversation.getName())
                    .build();
        } catch (Exception e) {
            log.error("ConversationServiceImpl | create | ERROR: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

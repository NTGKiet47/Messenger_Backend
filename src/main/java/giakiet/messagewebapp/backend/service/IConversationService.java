package giakiet.messagewebapp.backend.service;

import giakiet.messagewebapp.backend.dto.ConversationDto;

import java.util.List;

public interface IConversationService {

    ConversationDto create(ConversationDto conversationDto);

}

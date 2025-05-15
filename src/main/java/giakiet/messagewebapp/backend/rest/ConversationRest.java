package giakiet.messagewebapp.backend.rest;

import giakiet.messagewebapp.backend.constant.ApiConstant;
import giakiet.messagewebapp.backend.dto.ConversationDto;
import giakiet.messagewebapp.backend.exception.CustomException;
import giakiet.messagewebapp.backend.service.IConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstant.API_CONVERSATION)
public class ConversationRest {

    private final IConversationService conversationService;

    @PostMapping(ApiConstant.API_CREATE)
    public ConversationDto create(@RequestBody ConversationDto conversationDto){
        return conversationService.create(conversationDto);
    }

}

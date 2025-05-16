package giakiet.messagewebapp.backend.rest;

import giakiet.messagewebapp.backend.constant.ApiConstant;
import giakiet.messagewebapp.backend.constant.UserConsant;
import giakiet.messagewebapp.backend.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class MessageController {

    @MessageMapping(ApiConstant.API_SEND_MESSAGE)
    @SendTo(ApiConstant.API_TOPIC_PUBLIC)
    public MessageDto sendMessage(@RequestBody MessageDto messageDto) {
        return messageDto;
    }

    @MessageMapping(ApiConstant.API_ADD_USER)
    @SendTo(ApiConstant.API_TOPIC_PUBLIC)
    public MessageDto addUser(@RequestBody MessageDto messageDto, SimpMessageHeaderAccessor headerAccessor) {
        Objects.requireNonNull(
                headerAccessor.getSessionAttributes()).put(UserConsant.USER_NAME, messageDto);
        return messageDto;
    }

}

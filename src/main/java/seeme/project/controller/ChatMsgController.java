package seeme.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seeme.project.service.ChatMsgService;
import seeme.project.service.ViewerService;

@Controller
public class ChatMsgController {

    private final ChatMsgService chatMsgService;

    @Autowired
    public ChatMsgController(ChatMsgService chatMsgService){
        this.chatMsgService = chatMsgService;
    }

}

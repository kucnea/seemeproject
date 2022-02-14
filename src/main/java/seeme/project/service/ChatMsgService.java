package seeme.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seeme.project.domain.ChatMsg;
import seeme.project.repository.ChatMsgRepository;
import seeme.project.repository.ViewerRepository;

import java.util.Calendar;

@Service
@Transactional(rollbackFor = Exception.class)
public class ChatMsgService {

    @Autowired private ChatMsgRepository chatMsgRepository;

    public ChatMsg sendChat(ChatMsg chatMsg){
        chatMsg.setCMIdx(creatCMIdx());
        return chatMsgRepository.save(chatMsg);
    }

    private Long creatCMIdx() {
       return Calendar.getInstance().getTimeInMillis();
    }

}

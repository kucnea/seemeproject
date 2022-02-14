package seeme.project.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.web.util.HtmlUtils;
import seeme.project.domain.ChatMsg;
import seeme.project.repository.ChatMsgRepository;
import seeme.project.repository.MemoryViewerRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ChatMsgServiceTest {

    @Autowired ChatMsgRepository chatMsgRepository;

    @AfterEach
    void afterEach(){
        chatMsgRepository.deleteAll();
    }

    @Test
    void sendChat() {

        //given
        ChatMsg chatMsg = new ChatMsg();
        chatMsg.setCMIdx(createIndex());
        chatMsg.setCMWriterIdx(1L);
        chatMsg.setCMReaderIdx(1L);
        chatMsg.setCMRead(false);
        chatMsg.setCMMsg("안녕하세요");

        //when
        chatMsg = chatMsgRepository.save(chatMsg);

        //then
        System.out.println("chatMsg.toString() : "+chatMsg.toString());



        Calendar cal = Calendar.getInstance();
    }

    Long createIndex(){
        Long result = Long.parseLong(
                new SimpleDateFormat("YYYYMMddhhmmssSSS")
                        .format(Calendar.getInstance().getTimeInMillis()));
        return result;
    }
}

//given

//when

//then
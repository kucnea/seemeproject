package seeme.project.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import seeme.project.domain.ChatMsg;
import seeme.project.repository.ChatMsgRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ChatMsgServiceTest {

    @Autowired ChatMsgRepository chatMsgRepository;

    @AfterEach
    void afterEach(){    }

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
        return Long.parseLong(
                new SimpleDateFormat("YYYYMMddhhmmssSSS")
                        .format(Calendar.getInstance().getTimeInMillis()));
    }




}

//given

//when

//then
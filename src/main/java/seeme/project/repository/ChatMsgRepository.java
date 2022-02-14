package seeme.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seeme.project.domain.ChatMsg;

@Repository
public interface ChatMsgRepository  extends JpaRepository<ChatMsg, Long> {

}

package seeme.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CHATMSG")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChatMsg {

    @Id
    private Long cMIdx;
    private Long cMWriterIdx;
    private Long cMReaderIdx;
    private boolean cMRead;
    private String cMMsg;

//    @ManyToOne
//    @JoinColumn(name="cRIdx" referencedColumnName="cRIdx")
//    private ChatRoom chatRoom;
}

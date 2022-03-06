package seeme.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="CHATROOM")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChatRoom {

    @Id
    private Long cRIdx;
    @Temporal(TemporalType.TIMESTAMP)
    private Date cRDate = new Date();

//    @OneToMany(mappedBy = "chatroom", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
//    private Set<Viewer> viewers;

//    @OneToMany(mappedBy = "chatroom", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
//    private Set<ChatMsg> chatMsgs;


}

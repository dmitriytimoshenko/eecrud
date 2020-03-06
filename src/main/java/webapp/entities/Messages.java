package webapp.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "messages")
public class Messages {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id_message;

    @Column(name = "size")
    int size;

    @Column(name = "isaddition")
    boolean isaddition;

    @Column(name = "senddate")
    String senddate;




    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "protocols_id", nullable = true)
    private Protocols protocols;

    @OneToOne(optional = false)
    @JoinColumn(name = "additions_id", unique = true, nullable = true, updatable = false)
    Additions additions;


    @OneToOne(optional = false)
    @JoinColumn(name = "md_id", unique = true, nullable = true, updatable = false)
    Message_data messageData;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "messagesfrom")
    Set<Accounts> accountsfrom;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "messagesto")
    Set<Accounts> accountsto;




    public Protocols getProtocols() {
        return protocols;
    }

    public void setProtocols(Protocols protocols) {
        this.protocols = protocols;
    }

    public Additions getAdditions() {
        return additions;
    }

    public void setAdditions(Additions additions) {
        this.additions = additions;
    }

    public Set<Accounts> getAccountsfrom() {
        return accountsfrom;
    }

    public void setAccountsfrom(Set<Accounts> accountsfrom) {
        this.accountsfrom = accountsfrom;
    }

    public Set<Accounts> getAccountsto() {
        return accountsto;
    }

    public void setAccountsto(Set<Accounts> accountsto) {
        this.accountsto = accountsto;
    }

    public Message_data getMessageData() {
        return messageData;
    }

    public void setMessageData(Message_data messageData) {
        this.messageData = messageData;
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isIsaddition() {
        return isaddition;
    }

    public void setIsaddition(boolean isaddition) {
        this.isaddition = isaddition;
    }

    public String getSenddate() {
        return senddate;
    }

    public void setSenddate(String senddate) {
        this.senddate = senddate;
    }


}

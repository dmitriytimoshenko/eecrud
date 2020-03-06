package webapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "message_data")
public class Message_data {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id_md;

    @Column(name = "text")
    String text;



    @OneToOne(optional = false, mappedBy = "messageData")
    private Messages messages;

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;

    }

    public int getId_md() {
        return id_md;
    }

    public void setId_md(int id_md) {
        this.id_md = id_md;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

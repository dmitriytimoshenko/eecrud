package webapp.entities;


import javax.persistence.*;

@Entity
@Table(name = "additions")
public class Additions {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id_add;

    @Column(name = "format")
    String format;

    @Column(name = "isactive")
    boolean isactive;


    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    @OneToOne(optional = false, mappedBy = "additions")
    private Messages messages;

    public int getId_add() {
        return id_add;
    }

    public void setId_add(int id_add) {
        this.id_add = id_add;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
}

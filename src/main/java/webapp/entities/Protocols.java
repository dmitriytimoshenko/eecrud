package webapp.entities;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "protocols")
public class Protocols {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id_prot;

    @Column(name = "type")
    String type;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "protocols")
    private Set<Messages> messages;

    public Set<Messages> getMessages() {
        return messages;
    }

    public void setMessages(Set<Messages> messages) {
        this.messages = messages;
    }

    public int getId_prot() {
        return id_prot;
    }




    public void setId_prot(int id_prot) {
        this.id_prot = id_prot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

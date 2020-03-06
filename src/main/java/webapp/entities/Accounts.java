package webapp.entities;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Accounts {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id_acc;

    @Column(name = "login")
    String login;

    @Column(name = "password")
    String password;

    @Column(name = "isactive")
    boolean isactive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "domain_id", nullable = true)
    private Domains domains;
    public Domains getDomains() {
        return domains;
    }

    public void setDomains(Domains domains) {
        this.domains = domains;
    }



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_id", nullable = true)
    private Rules rules;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "messagesfrom_id", nullable = true)
    private Messages messagesfrom;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "messagesto_id", nullable = true)
    private Messages messagesto;



    public int getId_acc() {
        return id_acc;
    }

    public void setId_acc(int id_acc) {
        this.id_acc = id_acc;
    }


    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }



    public Messages getMessagesfrom() {
        return messagesfrom;
    }

    public void setMessagesfrom(Messages messagesfrom) {
        this.messagesfrom = messagesfrom;
    }

    public Messages getMessagesto() {
        return messagesto;
    }

    public void setMessagesto(Messages messagesto) {
        this.messagesto = messagesto;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

}

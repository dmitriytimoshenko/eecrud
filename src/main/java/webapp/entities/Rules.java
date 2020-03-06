package webapp.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rules")
public class Rules {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id_rule;

    @Column(name = "rlname")
    String rlname;

    @Column(name = "isactive")
    boolean isactive;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rules")
    private Set<Accounts> accounts;



    public int getId_rule() {
        return id_rule;
    }

    public void setId_rule(int id_rule) {
        this.id_rule = id_rule;
    }

    public String getRlname() {
        return rlname;
    }

    public void setRlname(String rlname) {
        this.rlname = rlname;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public Set<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Accounts> accounts) {
        this.accounts = accounts;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
}

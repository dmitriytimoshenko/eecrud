package webapp.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "domains")
public class Domains {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id_domain;

    @Column(name = "name")
    String name;

    @Column(name = "isactive")
    boolean isactive;

    @Column(name = "storesize")
    int storesize;



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "domains")
    private Set<Accounts> accounts;
    public Set<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Accounts> accounts) {
        this.accounts = accounts;
    }


    public int getId_domain() {
        return id_domain;
    }

    public void setId_domain(int id_domain) {
        this.id_domain = id_domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public int getStoresize() {
        return storesize;
    }

    public void setStoresize(int storesize) {
        this.storesize = storesize;
    }




}

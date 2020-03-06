package webapp.entities;


import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {


    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

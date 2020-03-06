package webapp.Controllers.Accounts;



import webapp.entities.Accounts;
import webapp.entities.Domains;
import webapp.entities.Messages;
import webapp.entities.Rules;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Named
@SessionScoped
public class AccountsCDI implements Serializable {
    private String login;
    private String newlogin;
    private String dellogin;
    private String searchlogin;
    private String oldlogin;

    private String password;
    private String newpassword;
    private String delpassword;
    private String searchpassword;
    private String oldpassword;

    private boolean isactive;
    private boolean newisactive;
    private boolean delisactive;
    private boolean searchisactive;
    private boolean oldisactive;


    private int id_domains;
    private int id_newdomains;
    private int id_deldomains;
    private int id_searchdomains;
    private int id_olddomains;

    private int id_rules;
    private int id_newrules;
    private int id_delrules;
    private int id_searchrules;
    private int id_oldrules;

    private int id_messagesfrom;
    private int id_newmessagesfrom;
    private int id_delmessagesfrom;
    private int id_searchmessagesfrom;
    private int id_oldmessagesfrom;

    private int id_messagesto;
    private int id_newmessagesto;
    private int id_delmessagesto;
    private int id_searchmessagesto;
    private int id_oldmessagesto;


    @EJB
    private AccountsEJB accountsEJB;


    public int getId_rules() {
        return id_rules;
    }

    public void setId_rules(int id_rules) {
        this.id_rules = id_rules;
    }

    public int getId_newrules() {
        return id_newrules;
    }

    public void setId_newrules(int id_newrules) {
        this.id_newrules = id_newrules;
    }

    public int getId_delrules() {
        return id_delrules;
    }

    public void setId_delrules(int id_delrules) {
        this.id_delrules = id_delrules;
    }

    public int getId_searchrules() {
        return id_searchrules;
    }

    public void setId_searchrules(int id_searchrules) {
        this.id_searchrules = id_searchrules;
    }

    public int getId_oldrules() {
        return id_oldrules;
    }

    public void setId_oldrules(int id_oldrules) {
        this.id_oldrules = id_oldrules;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNewlogin() {
        return newlogin;
    }

    public void setNewlogin(String newlogin) {
        this.newlogin = newlogin;
    }

    public String getDellogin() {
        return dellogin;
    }

    public void setDellogin(String dellogin) {
        this.dellogin = dellogin;
    }

    public String getSearchlogin() {
        return searchlogin;
    }

    public void setSearchlogin(String searchlogin) {
        this.searchlogin = searchlogin;
    }

    public String getOldlogin() {
        return oldlogin;
    }

    public void setOldlogin(String oldlogin) {
        this.oldlogin = oldlogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getDelpassword() {
        return delpassword;
    }

    public void setDelpassword(String delpassword) {
        this.delpassword = delpassword;
    }

    public String getSearchpassword() {
        return searchpassword;
    }

    public void setSearchpassword(String searchpassword) {
        this.searchpassword = searchpassword;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public boolean isNewisactive() {
        return newisactive;
    }

    public void setNewisactive(boolean newisactive) {
        this.newisactive = newisactive;
    }

    public boolean isDelisactive() {
        return delisactive;
    }

    public void setDelisactive(boolean delisactive) {
        this.delisactive = delisactive;
    }

    public boolean isSearchisactive() {
        return searchisactive;
    }

    public void setSearchisactive(boolean searchisactive) {
        this.searchisactive = searchisactive;
    }

    public boolean isOldisactive() {
        return oldisactive;
    }

    public void setOldisactive(boolean oldisactive) {
        this.oldisactive = oldisactive;
    }

    public int getId_domains() {
        return id_domains;
    }

    public void setId_domains(int id_domains) {
        this.id_domains = id_domains;
    }


    public int getId_messagesfrom() {
        return id_messagesfrom;
    }

    public void setId_messagesfrom(int id_messagesfrom) {
        this.id_messagesfrom = id_messagesfrom;
    }


    public int getId_messagesto() {
        return id_messagesto;
    }

    public void setId_messagesto(int id_messagesto) {
        this.id_messagesto = id_messagesto;
    }


    public void createAcc() {
        accountsEJB.createAcc(login, password, isactive, id_domains, id_rules, id_messagesfrom, id_messagesto);
    }

    public void updateAcc() {
        accountsEJB.updateAcc(oldlogin, newlogin, oldpassword, newpassword, oldisactive, newisactive);
    }


    public void delAcc() {
        accountsEJB.delAcc(dellogin, delpassword, delisactive);
    }

    public List<Accounts> getAcc() {
        return accountsEJB.getAcc(searchlogin, searchpassword, searchisactive);

    }

    public List<Accounts> getAllAcc() {
        return accountsEJB.getAllAcc();
    }
}

package webapp.Controllers.Rules;

import webapp.entities.Rules;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class RulesCDI implements Serializable {


    private String rlname;
    private String newrlname;
    private String delrlname;
    private String searchrlname;
    private String oldrlname;

    private boolean isactive;
    private boolean newisactive;
    private boolean delisactive;
    private boolean searchisactive;
    private boolean oldisactive;

    public String getRlname() {
        return rlname;
    }

    public void setRlname(String rlname) {
        this.rlname = rlname;
    }

    public String getNewrlname() {
        return newrlname;
    }

    public void setNewrlname(String newrlname) {
        this.newrlname = newrlname;
    }

    public String getDelrlname() {
        return delrlname;
    }

    public void setDelrlname(String delrlname) {
        this.delrlname = delrlname;
    }

    public String getSearchrlname() {
        return searchrlname;
    }

    public void setSearchrlname(String searchrlname) {
        this.searchrlname = searchrlname;
    }

    public String getOldrlname() {
        return oldrlname;
    }

    public void setOldrlname(String oldrlname) {
        this.oldrlname = oldrlname;
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


    @EJB
    private RulesEJB rulesEJB;

    public void createRules() {
        rulesEJB.createRules(rlname, isactive);
    }

    public void updateRules() {
        rulesEJB.updateRules(oldrlname, newrlname, oldisactive, newisactive);
    }


    public void delRules() {
        rulesEJB.delRules(delrlname, delisactive);
    }

    public List<Rules> getRules() {
        return rulesEJB.getRules(searchrlname, searchisactive);

    }

    public List<Rules> getAllRules() {
        return rulesEJB.getAllRules();
    }
}

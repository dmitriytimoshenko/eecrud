package webapp.Controllers.Domains;

import webapp.entities.Domains;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DomainsCDI implements Serializable{
    private String name;
    private String newname;
    private String delname;
    private String searchname;
    private String oldname;

    private boolean isactive;
    private boolean newisactive;
    private boolean delisactive;
    private boolean searchisactive;
    private boolean oldisactive;

    private int storesize;
    private int newstoresize;
    private int delstoresize;
    private int searchstoresize;
    private int oldstoresize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname;
    }

    public String getDelname() {
        return delname;
    }

    public void setDelname(String delname) {
        this.delname = delname;
    }

    public String getSearchname() {
        return searchname;
    }

    public void setSearchname(String searchname) {
        this.searchname = searchname;
    }

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname;
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

    public int getStoresize() {
        return storesize;
    }

    public void setStoresize(int storesize) {
        this.storesize = storesize;
    }

    public int getNewstoresize() {
        return newstoresize;
    }

    public void setNewstoresize(int newstoresize) {
        this.newstoresize = newstoresize;
    }

    public int getDelstoresize() {
        return delstoresize;
    }

    public void setDelstoresize(int delstoresize) {
        this.delstoresize = delstoresize;
    }

    public int getSearchstoresize() {
        return searchstoresize;
    }

    public void setSearchstoresize(int searchstoresize) {
        this.searchstoresize = searchstoresize;
    }

    public int getOldstoresize() {
        return oldstoresize;
    }

    public void setOldstoresize(int oldstoresize) {
        this.oldstoresize = oldstoresize;
    }

    @EJB
    private DomainsEJB domainsEJB;

    public void createDomains() {
        domainsEJB.createDomains(name, isactive, storesize);
    }

    public void updateDomains() {
        domainsEJB.updateDomains(oldname, newname, oldisactive, newisactive, oldstoresize, newstoresize);
    }


    public void delDomains() {
        domainsEJB.delDomains(delname, delisactive, delstoresize);
    }

    public List<Domains> getDomains() {
        return domainsEJB.getDomains(searchname, searchisactive, searchstoresize);

    }

    public List<Domains> getAllDomains() {
        return domainsEJB.getAllDomains();
    }
}

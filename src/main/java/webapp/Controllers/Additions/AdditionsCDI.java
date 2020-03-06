package webapp.Controllers.Additions;

import webapp.entities.Additions;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AdditionsCDI implements Serializable {
    private String format;
    private String newformat;
    private String delformat;
    private String searchformat;
    private String oldformat;

    private boolean isactive;
    private boolean newisactive;
    private boolean delisactive;
    private boolean searchisactive;
    private boolean oldisactive;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getNewformat() {
        return newformat;
    }

    public void setNewformat(String newformat) {
        this.newformat = newformat;
    }

    public String getDelformat() {
        return delformat;
    }

    public void setDelformat(String delformat) {
        this.delformat = delformat;
    }

    public String getSearchformat() {
        return searchformat;
    }

    public void setSearchformat(String searchformat) {
        this.searchformat = searchformat;
    }

    public String getOldformat() {
        return oldformat;
    }

    public void setOldformat(String oldformat) {
        this.oldformat = oldformat;
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
    private AdditionsEJB additionsEJB;

    public void createAdd() {
        additionsEJB.createAdd(format, isactive);
    }

    public void updateAdd() {
        additionsEJB.updateAdd(oldformat, newformat, oldisactive, newisactive);
    }


    public void delAdd() {
        additionsEJB.delAdd(delformat, delisactive);
    }

    public List<Additions> getAdd() {
        return additionsEJB.getAdd(searchformat, searchisactive);

    }

    public List<Additions> getAllAdd() {
        return additionsEJB.getAllAdd();
    }
}

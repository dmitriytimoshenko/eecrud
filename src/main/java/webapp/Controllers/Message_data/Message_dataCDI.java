package webapp.Controllers.Message_data;


import webapp.entities.Message_data;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class Message_dataCDI implements Serializable {
    private String text;
    private String newtext;
    private String deltext;
    private String searchtext;
    private String oldtext;


    @EJB
    Message_dataEJB message_dataEJB;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNewtext() {
        return newtext;
    }

    public void setNewtext(String newtext) {
        this.newtext = newtext;
    }

    public String getDeltext() {
        return deltext;
    }

    public void setDeltext(String deltext) {
        this.deltext = deltext;
    }

    public String getSearchtext() {
        return searchtext;
    }

    public void setSearchtext(String searchtext) {
        this.searchtext = searchtext;
    }

    public String getOldtext() {
        return oldtext;
    }

    public void setOldtext(String oldtext) {
        this.oldtext = oldtext;
    }

    public void createMD() {
        message_dataEJB.createMD(text);
    }

    public void updateMD() {
        message_dataEJB.updateMD(oldtext, newtext);
    }


    public void delMD() {
        message_dataEJB.delMD(deltext);
    }

    public List<Message_data> getMD() {
        return message_dataEJB.getMD(searchtext);

    }

    public List<Message_data> getAllMD() {
        return message_dataEJB.getAllMD();
    }
}

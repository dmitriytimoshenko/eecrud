package webapp.Controllers.Messages;

import webapp.entities.*;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Named
@SessionScoped
public class MessagesCDI implements Serializable {
    private int size;
    private int newsize;
    private int delsize;
    private int searchsize;
    private int oldsize;

    private boolean isaddition;
    private boolean newisaddition;
    private boolean delisaddition;
    private boolean searchisaddition;
    private boolean oldisaddition;

    private String senddate;
    private String newsenddate;
    private String delsenddate;
    private String searchsenddate;
    private String oldsenddate;

    private int id_protocols;
    private int id_newprotocols;
    private int id_delprotocols;
    private int id_searchprotocols;
    private int id_oldprotocols;

    private int id_additions;
    private int id_newadditions;
    private int id_deladditions;
    private int id_searchadditions;
    private int id_oldadditions;


    private int id_messageData;
    private int id_newmessageData;
    private int id_delmessageData;
    private int id_searchmessageData;
    private int id_oldmessageData;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNewsize() {
        return newsize;
    }

    public void setNewsize(int newsize) {
        this.newsize = newsize;
    }

    public int getDelsize() {
        return delsize;
    }

    public void setDelsize(int delsize) {
        this.delsize = delsize;
    }

    public int getSearchsize() {
        return searchsize;
    }

    public void setSearchsize(int searchsize) {
        this.searchsize = searchsize;
    }

    public int getOldsize() {
        return oldsize;
    }

    public void setOldsize(int oldsize) {
        this.oldsize = oldsize;
    }

    public boolean isIsaddition() {
        return isaddition;
    }

    public void setIsaddition(boolean isaddition) {
        this.isaddition = isaddition;
    }

    public boolean isNewisaddition() {
        return newisaddition;
    }

    public void setNewisaddition(boolean newisaddition) {
        this.newisaddition = newisaddition;
    }

    public boolean isDelisaddition() {
        return delisaddition;
    }

    public void setDelisaddition(boolean delisaddition) {
        this.delisaddition = delisaddition;
    }

    public boolean isSearchisaddition() {
        return searchisaddition;
    }

    public void setSearchisaddition(boolean searchisaddition) {
        this.searchisaddition = searchisaddition;
    }

    public boolean isOldisaddition() {
        return oldisaddition;
    }

    public void setOldisaddition(boolean oldisaddition) {
        this.oldisaddition = oldisaddition;
    }

    public String getSenddate() {
        return senddate;
    }

    public void setSenddate(String senddate) {
        this.senddate = senddate;
    }

    public String getNewsenddate() {
        return newsenddate;
    }

    public void setNewsenddate(String newsenddate) {
        this.newsenddate = newsenddate;
    }

    public String getDelsenddate() {
        return delsenddate;
    }

    public void setDelsenddate(String delsenddate) {
        this.delsenddate = delsenddate;
    }

    public String getSearchsenddate() {
        return searchsenddate;
    }

    public void setSearchsenddate(String searchsenddate) {
        this.searchsenddate = searchsenddate;
    }

    public String getOldsenddate() {
        return oldsenddate;
    }

    public void setOldsenddate(String oldsenddate) {
        this.oldsenddate = oldsenddate;
    }

    public int getId_protocols() {
        return id_protocols;
    }

    public void setId_protocols(int id_protocols) {
        this.id_protocols = id_protocols;
    }

    public int getId_newprotocols() {
        return id_newprotocols;
    }

    public void setId_newprotocols(int id_newprotocols) {
        this.id_newprotocols = id_newprotocols;
    }

    public int getId_delprotocols() {
        return id_delprotocols;
    }

    public void setId_delprotocols(int id_delprotocols) {
        this.id_delprotocols = id_delprotocols;
    }

    public int getId_searchprotocols() {
        return id_searchprotocols;
    }

    public void setId_searchprotocols(int id_searchprotocols) {
        this.id_searchprotocols = id_searchprotocols;
    }

    public int getId_oldprotocols() {
        return id_oldprotocols;
    }

    public void setId_oldprotocols(int id_oldprotocols) {
        this.id_oldprotocols = id_oldprotocols;
    }

    public int getId_additions() {
        return id_additions;
    }

    public void setId_additions(int id_additions) {
        this.id_additions = id_additions;
    }

    public int getId_newadditions() {
        return id_newadditions;
    }

    public void setId_newadditions(int id_newadditions) {
        this.id_newadditions = id_newadditions;
    }

    public int getId_deladditions() {
        return id_deladditions;
    }

    public void setId_deladditions(int id_deladditions) {
        this.id_deladditions = id_deladditions;
    }

    public int getId_searchadditions() {
        return id_searchadditions;
    }

    public void setId_searchadditions(int id_searchadditions) {
        this.id_searchadditions = id_searchadditions;
    }

    public int getId_oldadditions() {
        return id_oldadditions;
    }

    public void setId_oldadditions(int id_oldadditions) {
        this.id_oldadditions = id_oldadditions;
    }

    public int getId_messageData() {
        return id_messageData;
    }

    public void setId_messageData(int id_messageData) {
        this.id_messageData = id_messageData;
    }

    public int getId_newmessageData() {
        return id_newmessageData;
    }

    public void setId_newmessageData(int id_newmessageData) {
        this.id_newmessageData = id_newmessageData;
    }

    public int getId_delmessageData() {
        return id_delmessageData;
    }

    public void setId_delmessageData(int id_delmessageData) {
        this.id_delmessageData = id_delmessageData;
    }

    public int getId_searchmessageData() {
        return id_searchmessageData;
    }

    public void setId_searchmessageData(int id_searchmessageData) {
        this.id_searchmessageData = id_searchmessageData;
    }

    public int getId_oldmessageData() {
        return id_oldmessageData;
    }

    public void setId_oldmessageData(int id_oldmessageData) {
        this.id_oldmessageData = id_oldmessageData;
    }

    @EJB
    MessagesEJB messagesEJB;


    public void createMessages() {
        messagesEJB.createMessages(size, isaddition, senddate, id_protocols, id_additions, id_messageData);
    }

    public void updateMessages() {
        messagesEJB.updateMessages(oldsize, newsize, oldisaddition, newisaddition, oldsenddate, newsenddate);
    }


    public void delMessages() {
        messagesEJB.delMessages(delsize, delisaddition, delsenddate);
    }

    public List<Messages> getMessages() {
        return messagesEJB.getMessages(searchsize, searchisaddition, searchsenddate);

    }

    public List<Messages> getAllMessages() {
        return messagesEJB.getAllMessages();
    }
}

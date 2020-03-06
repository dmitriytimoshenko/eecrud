package webapp.Controllers.Protocols;

import webapp.entities.Protocols;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProtocolsCDI implements Serializable {
    private String type;
    private String newtype;
    private String deltype;
    private String searchtype;
    private String oldtype;

    public String getOldtype() {
        return oldtype;
    }

    public void setOldtype(String oldtype) {
        this.oldtype = oldtype;
    }

    @EJB
    ProtocolsEJB protocolsEJB;


    public String getSearchtype() {
        return searchtype;
    }

    public void setSearchtype(String searchtype) {
        this.searchtype = searchtype;
    }

    public String getDeltype() {
        return deltype;
    }

    public void setDeltype(String deltype) {
        this.deltype = deltype;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNewtype() {
        return newtype;
    }

    public void setNewtype(String newtype) {
        this.newtype = newtype;
    }


    public void createProt() {
        protocolsEJB.createProt(type);
    }

    public void updateProt() {
        protocolsEJB.updateProt(oldtype, newtype);
    }


    public void delProt() {
        protocolsEJB.delProt(deltype);
    }

    public List<Protocols> getProt() {
       return protocolsEJB.getProt(searchtype);

    }

    public List<Protocols> getAllProt() {
        return protocolsEJB.getAllProt();
    }


}

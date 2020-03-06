package webapp.Controllers.Protocols;

import org.hibernate.*;
import webapp.entities.Protocols;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class ProtocolsEJB {
    @PersistenceContext(name = "examplePU")
    private EntityManager entityManager;


    public Protocols createProt(String type) {
        Protocols protocols = new Protocols();
        protocols.setType(type);
        entityManager.persist(protocols);
        return protocols;
    }


    public void delProt(String deltype) {
            Query query = entityManager.createQuery("delete from Protocols entity where entity.type = :deltype");
            query.setParameter("deltype", deltype);
            query.executeUpdate();
    }

    public void updateProt(String oldtype, String newtype) {
        Query updateQuery = entityManager.createQuery("update Protocols entity set entity.type =:newtype where entity.type = :oldtype");
        updateQuery.setParameter("oldtype",oldtype);
        updateQuery.setParameter("newtype",newtype);
        updateQuery.executeUpdate();
    }


    public List<Protocols> getProt(String searchtype) {
           Query query = entityManager.createQuery("select entity from Protocols entity where entity.type = :searchtype");
           query.setParameter("searchtype", searchtype);
           return query.getResultList();
    }


    public List<Protocols> getAllProt() {
        Query query = entityManager.createQuery("select entity from Protocols entity");
        return query.getResultList();
    }
}

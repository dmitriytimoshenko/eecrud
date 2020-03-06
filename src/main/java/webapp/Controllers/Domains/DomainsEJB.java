package webapp.Controllers.Domains;

import webapp.entities.Domains;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class DomainsEJB {
    @PersistenceContext(name = "examplePU")
    private EntityManager entityManager;

    public Domains createDomains(String name, boolean isactive, int storesize) {
        Domains domains = new Domains();
        domains.setName(name);
        domains.setIsactive(isactive);
        domains.setStoresize(storesize);
        entityManager.persist(domains);
        return domains;
    }


    public void delDomains(String delname, boolean delisactive, int delstoresize) {
        Query query = entityManager.createQuery("delete from Domains entity where entity.name = :delname and entity.isactive = :delisactive and entity.storesize = :delstoresize");
        query.setParameter("delname", delname);
        query.setParameter("delisactive", delisactive);
        query.setParameter("delstoresize", delstoresize);
        query.executeUpdate();
    }

    public void updateDomains(String oldname,String newname,boolean oldisactive,boolean newisactive, int oldstoresize,int newstoresize) {
        Query updateQuery = entityManager.createQuery(
                "update Domains entity " +
                        "set entity.name =:newname, entity.isactive =:newisactive, entity.storesize =:newstoresize " +
                        "where entity.name =:oldname and entity.isactive =:oldisactive and entity.storesize =:oldstoresize");
        updateQuery.setParameter("oldname",oldname);
        updateQuery.setParameter("newname",newname);
        updateQuery.setParameter("oldisactive",oldisactive);
        updateQuery.setParameter("newisactive",newisactive);
        updateQuery.setParameter("oldstoresize",oldstoresize);
        updateQuery.setParameter("newstoresize",newstoresize);
        updateQuery.executeUpdate();
    }


    public List<Domains> getDomains(String searchname,boolean searchisactive, int searchstoresize) {
        Query query = entityManager.createQuery("select entity from Domains entity where entity.name = :searchname and entity.isactive = :searchisactive and entity.storesize = :searchstoresize");
        query.setParameter("searchname", searchname);
        query.setParameter("searchisactive", searchisactive);
        query.setParameter("searchstoresize", searchstoresize);
        return query.getResultList();
    }


    public List<Domains> getAllDomains() {
        Query query = entityManager.createQuery("select entity from Domains entity");
        return query.getResultList();
    }
}

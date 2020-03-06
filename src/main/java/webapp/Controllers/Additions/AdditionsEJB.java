package webapp.Controllers.Additions;

import webapp.entities.Additions;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class AdditionsEJB {
    @PersistenceContext(name = "examplePU")
    private EntityManager entityManager;

    public Additions createAdd(String format, boolean isactive) {
        Additions additions = new Additions();
        additions.setFormat(format);
        additions.setIsactive(isactive);
        entityManager.persist(additions);
        return additions;
    }


    public void delAdd(String delformat, boolean delisactive) {
        Query query = entityManager.createQuery("delete from Additions entity where entity.format = :delformat and entity.isactive = :delisactive");
        query.setParameter("delformat", delformat);
        query.setParameter("delisactive", delisactive);
        query.executeUpdate();
    }

    public void updateAdd(String oldformat,String newformat,boolean oldisactive,boolean newisactive) {
        Query updateQuery = entityManager.createQuery(
                "update Additions entity " +
                        "set entity.format =:newformat, entity.isactive =:newisactive " +
                        "where entity.format =:oldformat and entity.isactive =:oldisactive");
        updateQuery.setParameter("oldformat",oldformat);
        updateQuery.setParameter("newformat",newformat);
        updateQuery.setParameter("oldisactive",oldisactive);
        updateQuery.setParameter("newisactive",newisactive);
        updateQuery.executeUpdate();
    }


    public List<Additions> getAdd(String searchformat,boolean searchisactive) {
        Query query = entityManager.createQuery("select entity from Additions entity where entity.format = :searchformat and entity.isactive = :searchisactive");
        query.setParameter("searchformat", searchformat);
        query.setParameter("searchisactive", searchisactive);
        return query.getResultList();
    }


    public List<Additions> getAllAdd() {
        Query query = entityManager.createQuery("select entity from Additions entity");
        return query.getResultList();
    }
}

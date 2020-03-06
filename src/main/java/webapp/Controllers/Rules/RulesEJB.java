package webapp.Controllers.Rules;

import webapp.entities.Rules;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class RulesEJB {
    @PersistenceContext(name = "examplePU")
    private EntityManager entityManager;

    public Rules createRules(String rlname, boolean isactive) {
        Rules rules = new Rules();
        rules.setRlname(rlname);
        rules.setIsactive(isactive);
        entityManager.persist(rules);
        return rules;
    }


    public void delRules(String delrlname, boolean delisactive) {
        Query query = entityManager.createQuery("delete from Rules entity where entity.rlname = :delrlname and entity.isactive = :delisactive");
        query.setParameter("delrlname", delrlname);
        query.setParameter("delisactive", delisactive);
        query.executeUpdate();
    }

    public void updateRules(String oldrlname,String newrlname,boolean oldisactive,boolean newisactive) {
        Query updateQuery = entityManager.createQuery(
                "update Rules entity " +
                        "set entity.rlname =:newrlname, entity.isactive =:newisactive " +
                        "where entity.rlname =:oldrlname and entity.isactive =:oldisactive");
        updateQuery.setParameter("oldrlname",oldrlname);
        updateQuery.setParameter("newrlname",newrlname);
        updateQuery.setParameter("oldisactive",oldisactive);
        updateQuery.setParameter("newisactive",newisactive);
        updateQuery.executeUpdate();
    }


    public List<Rules> getRules(String searchrlname,boolean searchisactive) {
        Query query = entityManager.createQuery("select entity from Rules entity where entity.rlname = :searchrlname and entity.isactive = :searchisactive");
        query.setParameter("searchrlname", searchrlname);
        query.setParameter("searchisactive", searchisactive);
        return query.getResultList();
    }


    public List<Rules> getAllRules() {
        Query query = entityManager.createQuery("select entity from Rules entity");
        return query.getResultList();
    }
}

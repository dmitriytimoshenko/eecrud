package webapp.Controllers.Accounts;


import webapp.entities.Accounts;
import webapp.entities.Domains;
import webapp.entities.Messages;
import webapp.entities.Rules;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Stateless
@LocalBean
public class AccountsEJB {
    @PersistenceContext(name = "examplePU")
    private EntityManager entityManager;


    public Accounts createAcc(String login,String password, boolean isactive, int id_domains, int id_rules, int id_messagefrom,
                              int id_messagesto) {
        Accounts accounts = new Accounts();
        Rules rules = entityManager.find(Rules.class, id_rules);
        Domains domains = entityManager.find(Domains.class, id_domains);
        Messages messagesfrom = entityManager.find(Messages.class, id_messagefrom);
        Messages messagesto = entityManager.find(Messages.class, id_messagesto);


        accounts.setDomains(domains);
        accounts.setRules(rules);
        accounts.setMessagesfrom(messagesfrom);
        accounts.setMessagesto(messagesto);

        accounts.setLogin(login);
        accounts.setPassword(password);
        accounts.setIsactive(isactive);
        entityManager.persist(accounts);
        return accounts;
    }


    public void delAcc(String dellogin,String delpassword, boolean delisactive) {
        Query query = entityManager.createQuery("delete from Accounts entity where entity.login = :dellogin and entity.password = :delpassword and entity.isactive = :delisactive");
        query.setParameter("dellogin", dellogin);
        query.setParameter("delpassword", delpassword);
        query.setParameter("delisactive", delisactive);
        query.executeUpdate();
    }

    public void updateAcc(String oldlogin,String newlogin,String oldpassword,String newpassword,
                          boolean oldisactive,boolean newisactive) {
        Query updateQuery = entityManager.createQuery(
                "update Accounts entity " +
                        "set entity.login =:newlogin,  entity.password =:newpassword, entity.isactive =:newisactive " +
                        "where entity.login =:oldlogin and entity.password =:oldpassword and entity.isactive =:oldisactive");
        updateQuery.setParameter("oldlogin",oldlogin);
        updateQuery.setParameter("newlogin",newlogin);
        updateQuery.setParameter("oldpassword",oldpassword);
        updateQuery.setParameter("newpassword",newpassword);
        updateQuery.setParameter("oldisactive",oldisactive);
        updateQuery.setParameter("newisactive",newisactive);
        updateQuery.executeUpdate();
    }


    public List<Accounts> getAcc(String searchlogin,String searchpassword, boolean searchisactive) {
        Query query = entityManager.createQuery("select entity from Accounts entity where entity.login = :searchlogin and entity.password = :searchpassword and entity.isactive = :searchisactive");
        query.setParameter("searchlogin", searchlogin);
        query.setParameter("searchpassword", searchpassword);
        query.setParameter("searchisactive", searchisactive);
        return query.getResultList();
    }


    public List<Accounts> getAllAcc() {
        Query query = entityManager.createQuery("select entity from Accounts entity");
        return query.getResultList();
    }
}

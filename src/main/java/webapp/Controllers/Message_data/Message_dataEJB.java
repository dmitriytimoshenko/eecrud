package webapp.Controllers.Message_data;

import webapp.entities.Message_data;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class Message_dataEJB {
    @PersistenceContext(name = "examplePU")
    private EntityManager entityManager;

    public Message_data createMD(String text) {
        Message_data message_data = new Message_data();
        message_data.setText(text);
        entityManager.persist(message_data);
        return message_data;
    }


    public void delMD(String deltext) {
        Query query = entityManager.createQuery("delete from Message_data entity where entity.text = :deltext");
        query.setParameter("deltext", deltext);
        query.executeUpdate();
    }

    public void updateMD(String oldtext, String newtext) {
        Query updateQuery = entityManager.createQuery(
                "update Message_data entity " +
                        "set entity.text =:newtext " +
                        "where entity.text =:oldtext");
        updateQuery.setParameter("oldtext",oldtext);
        updateQuery.setParameter("newtext",newtext);
        updateQuery.executeUpdate();
    }


    public List<Message_data> getMD(String searchtext) {
        Query query = entityManager.createQuery("select entity from Message_data entity where entity.text = :searchtext");
        query.setParameter("searchtext", searchtext);
        return query.getResultList();
    }


    public List<Message_data> getAllMD() {
        Query query = entityManager.createQuery("select entity from Message_data entity");
        return query.getResultList();
    }
}

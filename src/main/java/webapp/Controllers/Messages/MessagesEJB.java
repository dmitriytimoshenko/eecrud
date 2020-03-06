package webapp.Controllers.Messages;

import webapp.entities.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.time.LocalDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;


@Stateless
@LocalBean
public class MessagesEJB {
    @PersistenceContext(name = "examplePU")
    private EntityManager entityManager;

    public Messages createMessages(int size, boolean isaddition, String senddate,
                                   int id_protocols, int id_additions,
                                   int id_messageData) {

        Messages messages = new Messages();
        Protocols protocols = entityManager.find(Protocols.class, id_protocols);
        Additions additions = entityManager.find(Additions.class, id_additions);
        Message_data message_data = entityManager.find(Message_data.class, id_messageData);



        messages.setSenddate(senddate);
        messages.setSize(size);
        messages.setIsaddition(isaddition);
        messages.setProtocols(protocols);
        messages.setAdditions(additions);
        messages.setMessageData(message_data);
        entityManager.persist(messages);
        return messages;
    }


    public void delMessages(int delsize, boolean delisaddition, String delsenddate) {


        Query query = entityManager.createQuery("delete from Messages entity where entity.size = :delsize and entity.isaddition = :delisaddition " +
                "and entity.senddate = :delsenddate ");
        query.setParameter("delsize", delsize);
        query.setParameter("delisaddition", delisaddition);
        query.setParameter("delsenddate", delsenddate);
        query.executeUpdate();
    }

    public void updateMessages(int oldsize, int newsize, boolean oldisaddition, boolean newisaddition, String oldsenddate, String newsenddate) {




        Query updateQuery = entityManager.createQuery(
                "update Messages entity " +
                        "set entity.size =:newsize, entity.isaddition =:newisaddition, entity.senddate =:newsenddate " +
                        "where entity.size =:oldsize and entity.isaddition =:oldisaddition and entity.senddate =:oldsenddate");
        updateQuery.setParameter("oldsize",oldsize);
        updateQuery.setParameter("newsize",newsize);
        updateQuery.setParameter("oldisaddition",oldisaddition);
        updateQuery.setParameter("newisaddition",newisaddition);
        updateQuery.setParameter("oldsenddate",oldsenddate);
        updateQuery.setParameter("newsenddate",newsenddate);
        updateQuery.executeUpdate();
    }


    public List<Messages> getMessages(int searchsize, boolean searchisaddition, String searchsenddate) {



        Query query = entityManager.createQuery("select entity from Messages entity where entity.size = :searchsize and entity.isaddition = :searchisaddition and entity.senddate = :searchsenddate");
        query.setParameter("searchsize", searchsize);
        query.setParameter("searchisaddition", searchisaddition);
        query.setParameter("searchsenddate", searchsenddate);
        return query.getResultList();
    }


    public List<Messages> getAllMessages() {
        Query query = entityManager.createQuery("select entity from Messages entity");
        return query.getResultList();
    }
}

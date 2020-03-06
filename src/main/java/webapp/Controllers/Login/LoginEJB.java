package webapp.Controllers.Login;

import org.apache.commons.lang.StringUtils;
import webapp.entities.Login;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class LoginEJB {
    @PersistenceContext(name = "examplePU")
    private EntityManager entityManager;

    public boolean logIn(String login, String password) {
        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
            return false;
        }

        Login log = entityManager.find(Login.class, login);
        if (log == null) {
            return false;
        }

        if (!password.equals(log.getPassword())) {
            return false;
        }
        return true;
    }
}

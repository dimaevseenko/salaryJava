package db.salary;

import jakarta.persistence.criteria.CriteriaQuery;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class UserTableImpl implements UserTable{

    private Session session;

    public UserTableImpl(Session session){
        this.session = session;
    }

    @Override
    public ArrayList<User> getUsers() {
        CriteriaQuery<User> cq = session.getCriteriaBuilder().createQuery(User.class);
        cq.from(User.class);
        return (ArrayList<User>) session.createQuery(cq).getResultList();
    }

    @Override
    public void addUser(User user) {
        Transaction t = session.beginTransaction();
        session.save(user);
        t.commit();
        session.close();
    }
}

package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private Session session;

    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    @Override
    public List<User> getAll() {
        Transaction transaction = session.beginTransaction();
        List<User> allUser = session.createQuery("FROM User").list();

        transaction.commit();
        session.close();
        return allUser;
    }

    @Override
    public void add(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);

        transaction.commit();
        session.close();
    }

    @Override
    public void deleteById(Integer id) {
        User user;
        Transaction transaction = session.beginTransaction();
        user = session.load(User.class, id);
        session.delete(user);

        transaction.commit();
        session.close();
    }
}

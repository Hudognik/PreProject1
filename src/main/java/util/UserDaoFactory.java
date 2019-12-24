package util;

import dao.DAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class UserDaoFactory {
    private static UserDaoFactory instance;
    private Properties properties = new Properties();
    private static SessionFactory sessionFactory;

    public static UserDaoFactory getInstance() {
        if (instance == null) {
            instance = new UserDaoFactory();
        }
        return instance;
    }

    public DAO<User, Integer> getDAO() {
        try {
            File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("config.property")).getFile());
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (properties.getProperty("daoType").equalsIgnoreCase("Hibernate")) {
            return getHibernateDAO();
        } else if (properties.getProperty("daoType").equalsIgnoreCase("JDBC")) {
            return getJdbcDAO();
        }
        return null;
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    private UserJdbcDAO getJdbcDAO() {
        try {
            return new UserJdbcDAO(DBHelper.getInstance().getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private UserHibernateDAO getHibernateDAO() {
        return new UserHibernateDAO(getSessionFactory().openSession());
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = DBHelper.getInstance().getConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
